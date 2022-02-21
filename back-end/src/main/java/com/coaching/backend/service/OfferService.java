package com.coaching.backend.service;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.coaching.backend.utils.OfferUtils.getCoachWithoutPersonalDetails;

@Service
@Transactional
public class OfferService {

    private final OfferRepository offerRepository;
    private final CoachService coachService;
    @PersistenceContext()
    EntityManager entityManager;
    private static final Logger LOG = LoggerFactory.getLogger(OfferService.class);

    public OfferService(OfferRepository offerRepository, CoachService coachService, EntityManager entityManager) {
        this.offerRepository = offerRepository;
        this.coachService = coachService;
        this.entityManager = entityManager;
    }

    /**
     * add new offer -- sets the coach in offer by finding it in the db
     * @param offer the offer to be added
     */
    public void addOffer(Offer offer){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOG.debug("the current user : {}", userDetails.getUsername());
        LOG.debug("creating new offer");
        offer.setCoach(coachService.findByEmail(userDetails.getUsername()));
        if (!offer.getCoach().isVerified()){
            LOG.debug("the coach is not verified + email : {}", offer.getCoach());
            throw new CoachIsNotVerifiedException(offer.getCoach().getEmail());
        }
        offerRepository.save(offer);
        LOG.debug("new offer created");
    }

    /**
     * get all offers having any of the tags
     * @param tags list of tags to search in
     * @return list of offers
     */
    public List<Offer> getOffersByTags(List<String> tags) {
        LOG.debug("searching offers by tags");
        Optional<List<Offer>> offers = offerRepository.findAllByTagsIn(tags);
        if (offers.isPresent()){
            for (Offer offer : offers.get()){
                offer.setCoach(getCoachWithoutPersonalDetails(offer.getCoach()));
            }
            return offers.get();
        }
        return new ArrayList<>();
    }

    /**
     * get all offers of a coach by his id, or his full name
     * @param coach the coach - must contain either id or full name
     * @return list of offers
     */
    public List<Offer> getOffersByCoach(Coach coach) {

        if (coach == null){
            throw new UserNullException(Role.COACH);
        }
        if (coach.getId()!=0){ // equivalent to id != null i guess
            return offerRepository.findAllByCoachId(coach.getId()).orElseGet(ArrayList::new);
        }
        // this will generate an error -- logical error -- when two coaches have the same full name
        if (coach.getFirstName() != null && coach.getLastName()!=null){
            return offerRepository.findAllOffersByCoachFirstNameAndCoachLastName(coach.getFirstName(), coach.getLastName()).orElseGet(ArrayList::new);
        }
        throw new UserIncompleteDataException("coach's id or full_name");
    }

    /**
     * search for offers by title
     * -- uses fuzzy search to match the title even if up to 3 letters are different --
     * @param title the title to search for
     * @return the list of offers matching the title
     */
    public List<Offer> getOffersByTitle(String title) {

        LOG.debug("searching offers by title : {}", title);
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.flushToIndexes();
        fullTextEntityManager.clear();
        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Offer.class)
                .get();

//        Query query = queryBuilder
//                .phrase()
//                .withSlop(3)
//                .onField("title")
//                .sentence(title)
//                .createQuery();
        Query query = queryBuilder
                .keyword()
                .onField("title")
                .matching("offer2")
                .createQuery();

        LOG.debug("expected : {}", offerRepository.findAllByTitle("offer2").get().size());

        List<Offer> res = fullTextEntityManager.createFullTextQuery(query, Offer.class).getResultList();

        return res;
    }
}
