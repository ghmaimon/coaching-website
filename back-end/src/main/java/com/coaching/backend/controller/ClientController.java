package com.coaching.backend.controller;

import com.coaching.backend.model.Coach;
import com.coaching.backend.model.DietPlan;
import com.coaching.backend.service.ClientService;
import com.coaching.backend.service.CoachService;
import com.coaching.backend.service.SuperUserService;
import com.coaching.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        return new ResponseEntity<List<DietPlan>>(
                clientService.getDietPlans(),
                HttpStatus.OK
        );
    }

}
