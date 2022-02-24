package com.coaching.backend.controller.controller;

import com.coaching.backend.DTO.dataDTO.OfferDTO;
import com.coaching.backend.DTO.dataDTO.OfferRequestDTO;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Offer;
import com.coaching.backend.service.*;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/offer")
public class OfferController {
    private OfferService offerService;
    private static final Logger LOG = LoggerFactory.getLogger(OfferController.class);

    /**
         * add new offer endpoint
     * @param offer the offer to add
     * @return the offer created with a https status of 201 in case of success
     */

    @PostMapping(path = "/add",
            consumes="multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> addOffer(@ModelAttribute OfferRequestDTO offer ) throws IOException, NoSuchAlgorithmException {
        return new ResponseEntity<>(
                offerService.addOffer(offer),
                HttpStatus.CREATED
        );
    }

    /**
     * delete existent offer endpoint
     * @param id the id of the offer
     */

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOffer(@PathVariable long id){
        LOG.debug("deleting offer : {}",id);
        offerService.deleteOffer(id);
    }
    /**
     * search offers by tags
     * @param tags list of tags
     * @return list of offers
     */
    @PostMapping(path = "/search/byTags",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> getOffersByTags(@Valid @RequestBody @NonNull List<String> tags){
        LOG.debug("getting offers by tags");
        List<OfferDTO> offers = offerService.getOffersByTags(tags);
        return new ResponseEntity<>(
                offers,
                HttpStatus.OK
        );
    }
    @PostMapping(path = "/search/byCoach",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> getOffersByCoach(@Valid @RequestBody Coach coach){
        LOG.debug("getting offers by coach");
        LOG.debug("{}", coach.toString());
        List<OfferDTO> offers = offerService.getOffersByCoach(coach);
        return new ResponseEntity<>(
                offers,
                HttpStatus.OK
        );
    }
    @PostMapping(path = "/search/byTitle",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDTO>> getOffersByTitle(@RequestBody String title) throws InterruptedException {
        LOG.debug("getting offers by title");
        LOG.debug("{}", title);
        List<OfferDTO> offers = offerService.getOffersByTitle(title);
        return new ResponseEntity<>(
                offers,
                HttpStatus.OK
        );
    }

}
