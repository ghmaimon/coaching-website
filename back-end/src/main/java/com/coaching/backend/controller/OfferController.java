package com.coaching.backend.controller;

import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Offer;
import com.coaching.backend.model.User;
import com.coaching.backend.service.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/offer")
public class OfferController {
    private OfferService offerService;
    private static final Logger LOG = LoggerFactory.getLogger(OfferController.class);

    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> addOffer(@Valid @RequestBody Offer offer){
        offerService.addOffer(offer);
        return new ResponseEntity<>(
                offer,
                HttpStatus.CREATED
        );
    }


}
