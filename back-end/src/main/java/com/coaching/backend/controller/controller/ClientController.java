package com.coaching.backend.controller.controller;

import com.coaching.backend.model.DietPlan;
import com.coaching.backend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientController{
    ClientService clientService;

    @GetMapping(path = "/diet_plans")
    public ResponseEntity<List<DietPlan>> getMyDietPlans(){
        return new ResponseEntity<>(
                clientService.getDietPlans(),
                HttpStatus.OK
        );
    }

}
