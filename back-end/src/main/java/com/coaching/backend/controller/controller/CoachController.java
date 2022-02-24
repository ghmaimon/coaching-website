package com.coaching.backend.controller.controller;

import com.coaching.backend.DTO.data.ClientDTO;
import com.coaching.backend.model.Client;
import com.coaching.backend.service.CoachService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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


    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getClients(@RequestHeader("Authorization") String jwtToken){
        return new ResponseEntity<>(
                coachService.getCoachsClients(jwtToken),
                HttpStatus.OK
        );
    }
}
