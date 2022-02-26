package com.coaching.backend.service;

import com.coaching.backend.DTO.dataDTO.OfferDTO;
import com.coaching.backend.DTO.dataDTO.OfferRequestDTO;
import com.coaching.backend.enumeration.Role;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
import com.coaching.backend.exception.OfferNotFoundException;
import com.coaching.backend.exception.UserIncompleteDataException;
import com.coaching.backend.exception.UserNullException;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Offer;
import com.coaching.backend.repository.OfferRepository;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.coaching.backend.utils.MyConverter.convertToDatabaseColumn;

@Service
@Transactional
public class OfferService {

    private OfferRepository offerRepository;
    private CoachService coachService;

    private FileService fileService;

    @PersistenceContext
    private EntityManager entityManager;

    public OfferService(OfferRepository offerRepository, CoachService coachService, @Lazy FileService fileService,@Lazy EntityManager entityManager) {
        this.offerRepository = offerRepository;
        this.coachService = coachService;
        this.fileService = fileService;
        this.entityManager = entityManager;
    }

    private static final Logger LOG = LoggerFactory.getLogger(OfferService.class);


    /**
     * add new offer -- sets the coach in offer by finding it in the db
     * @param offerDTO the offer to be added
     */
    public Offer addOffer(OfferRequestDTO offerDTO) throws IOException, NoSuchAlgorithmException {

//        UserDetails userName = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        LOG.debug("the current user : {}", userDetails.getUsername());
        LOG.debug("the current user : {}", email);
        LOG.debug("creating new offer");
        Offer offer = new Offer(
                coachService.findByEmail(email),
                convertToDatabaseColumn(offerDTO.tags()),
                offerDTO.title(),
                offerDTO.description(),
                offerDTO.minPrice(),
                offerDTO.maxPrice()
                );
//        offer.setCoach(coachService.findByEmail(userDetails.getUsername()));
        offer.setCoach(coachService.findByEmail(email));
        if (!offer.getCoach().isVerified()){
            LOG.debug("the coach is not verified + email : {}", offer.getCoach());
            throw new CoachIsNotVerifiedException(offer.getCoach().getEmail());
        }

        LOG.debug("new offer created");
        String img = fileService.uploadOfferImage(offer,offerDTO.image());
        LOG.debug("image : {}",img);
        offer.setImage(img);
        offerRepository.save(offer);
        return offer;
    }

    /**
     * get all offers having any of the tags
     * @param tags list of tags to search in
     * @return list of offers
     */
    public List<OfferDTO> getOffersByTags(List<String> tags) {
        LOG.debug("searching offers by tags");
        Optional<List<Offer>> offers = offerRepository.findAllByTagsIn(tags);
        if (offers.isPresent()){
            List<OfferDTO> offerDTOS = new ArrayList<>();
            for (Offer offer : offers.get()){
                offerDTOS.add(new OfferDTO(offer));
            }
            return offerDTOS;
        }
        return new ArrayList<>();
    }

    /**
     * get all offers of a coach by his id, or his full name
     * @param coach the coach - must contain either id or full name
     * @return list of offers
     */
    public List<OfferDTO> getOffersByCoach(Coach coach) {

        if (coach == null){
            throw new UserNullException(Role.COACH);
        }
        if (coach.getId()!=0){ // equivalent to id != null i guess
            Optional<List<Offer>> offers = offerRepository.findAllByCoachId(coach.getId());
            if (offers.isPresent()){
                return offers.get().stream().map(OfferDTO::new).toList();
            }
            return List.of();
        }
        // this will generate an error -- logical error -- when two coaches have the same full name
        if (coach.getFirstName() != null && coach.getLastName()!=null){
            Optional<List<Offer>> offers =  offerRepository.findAllOffersByCoachFirstNameAndCoachLastName(coach.getFirstName(), coach.getLastName());
            if (offers.isPresent()){
                return offers.get().stream().map(OfferDTO::new).toList();
            }
            return List.of();
        }
        throw new UserIncompleteDataException("coach's id or full_name");
    }

    /**
     * get my Offers
     * @return
     */
    public List<OfferDTO> getOffersByCoach() {
        return getOffersByCoach(coachService.findCurrentCoach());
    }

    /**
     * search for offers by title
     * -- uses fuzzy search to match the title even if up to 3 letters are different --
     * @param title the title to search for
     * @return the list of offers matching the title
     * TODO add the option to search by "contains" besides this fuzzy search
     */

    public List<OfferDTO> getOffersByTitle(String title) throws InterruptedException {


        LOG.debug("searching offers by title : {}", title);
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();
        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Offer.class)
                .get();

        Query query = queryBuilder
                .simpleQueryString()
//                .withSlop(3)
                .onField("title")
                .matching(title+" ~3")
                .createQuery();


        List<Offer> res = fullTextEntityManager.createFullTextQuery(query, Offer.class).getResultList();

        return res.stream().map(OfferDTO::new).toList();
    }

    public void deleteOffer(long id) {
        if (id == 0 || !offerRepository.existsById(id))// i guess 0 <==> null
            throw new OfferNotFoundException(id);
        offerRepository.deleteById(id);
    }

    public OfferDTO getOfferDtoById(long id) {
        return this.offerRepository.findById(id).map(OfferDTO::new).orElseThrow(() -> new OfferNotFoundException("422", "offer not found"));
    }
    public Offer getOfferById(long id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new OfferNotFoundException("422", "offer not found"));
    }

    public void setOfferImage(Offer offer, String documentName) {
        offer.setImage(documentName);
        offerRepository.save(offer);
    }

    public List<OfferDTO> getAllOffers() {
        List<Offer> offers =  offerRepository.findAll();
        return offers.stream().map(OfferDTO::new).toList();
    }
}
