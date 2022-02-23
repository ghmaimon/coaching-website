package com.coaching.backend.controller.controller;

import com.coaching.backend.model.MealContract;
import com.coaching.backend.model.TrainingContract;
import com.coaching.backend.service.ContractService;
import com.coaching.backend.service.MealContractService;
import com.coaching.backend.service.TrainingContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contract")
public class ContractController {

    ContractService contractService;
    TrainingContractService trainingContractService;
    MealContractService mealContractService;

    public ContractController(ContractService contractService, TrainingContractService trainingContractService, MealContractService mealContractService) {
        this.contractService = contractService;
        this.trainingContractService = trainingContractService;
        this.mealContractService = mealContractService;
    }

    @PostMapping(path = "/acceptTrainingContract")
    public ResponseEntity<TrainingContract> acceptTrainingContract(@RequestBody TrainingContract contract,
                                                                   @RequestHeader("Authorization") String jwtToken) {
        return new ResponseEntity<>(
                trainingContractService.createContract(contract, jwtToken),
                HttpStatus.OK
        );
    }

    @PostMapping(path = "/createMealContract")
    public ResponseEntity<MealContract> acceptMealContract(@RequestBody MealContract contract,
                                                           @RequestHeader("Authorization") String jwtToken) {
        return new ResponseEntity<>(
                mealContractService.createContract(contract, jwtToken),
                HttpStatus.OK
        );
    }
}