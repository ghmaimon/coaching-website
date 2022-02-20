package com.coaching.backend.service;

import com.coaching.backend.controller.OfferController;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
import com.coaching.backend.exception.CoachNotFoundException;
import com.coaching.backend.exception.UserException;
import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.Offer;
import com.coaching.backend.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.coaching.backend.utils.OfferUtils.getCoachWithoutPersonalDetails;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private CoachService coachService;
    private static final Logger LOG = LoggerFactory.getLogger(OfferService.class);

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
}
