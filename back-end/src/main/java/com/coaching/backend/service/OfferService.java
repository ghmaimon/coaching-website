package com.coaching.backend.service;

import com.coaching.backend.controller.OfferController;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
import com.coaching.backend.exception.CoachNotFoundException;
import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.Offer;
import com.coaching.backend.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private CoachService coachService;
    private static final Logger LOG = LoggerFactory.getLogger(OfferService.class);

    public void addOffer(Offer offer){
        LOG.debug("creating new offer");
        if (!coachService.exists(offer.getCoach())){
            throw new CoachNotFoundException(offer.getCoach().getEmail());
        }
        if (!offer.getCoach().isVerified()){
            throw new CoachIsNotVerifiedException(offer.getCoach().getEmail());
        }
        offerRepository.save(offer);
        LOG.debug("new offer created");
    }
}
