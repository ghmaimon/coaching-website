package com.coaching.backend.controller.controller;

import com.coaching.backend.DTO.dataDTO.ClientDTO;
import com.coaching.backend.model.Coach;
import com.coaching.backend.service.CoachService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/coach")
public class CoachController {
    CoachService coachService;

    private static final Logger LOG = LoggerFactory.getLogger(CoachController.class);
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getClients(@RequestHeader("Authorization") String jwtToken){
        return new ResponseEntity<>(
                coachService.getCoachsClients(jwtToken),
                HttpStatus.OK
        );
    }
    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Coach> getPersonalData(){
        LOG.debug("new personal data get request ");
        return new ResponseEntity<>(
                coachService.findCurrentCoach(),
                HttpStatus.OK
        );
    }

}
