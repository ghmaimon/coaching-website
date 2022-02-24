package com.coaching.backend.controller.controller;

import com.coaching.backend.DTO.dataDTO.TrainingContractDTO;
import com.coaching.backend.model.Contract;
import com.coaching.backend.model.MealContract;
import com.coaching.backend.model.TrainingContract;
import com.coaching.backend.service.ContractService;
import com.coaching.backend.service.MealContractService;
import com.coaching.backend.service.OfferService;
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
    OfferService offerService;

    public ContractController(ContractService contractService,
                              TrainingContractService trainingContractService,
                              MealContractService mealContractService,
                              OfferService offerService) {
        this.contractService = contractService;
        this.trainingContractService = trainingContractService;
        this.mealContractService = mealContractService;
        this.offerService = offerService;
    }

    @PostMapping(path = "/acceptTrainingContract")
    public ResponseEntity<TrainingContractDTO> acceptTrainingContract(@RequestBody TrainingContractDTO contractDTO,
                                                                   @RequestHeader("Authorization") String jwtToken) {
        Contract contract = new TrainingContract();
        contract.setPaid(contractDTO.paid());
        contract.setOffer(offerService.getOfferById(contractDTO.offer_id()));
        contract.setPrice(contractDTO.price());
        return new ResponseEntity<>(
                trainingContractService.createTrainingContract((TrainingContract) contract, jwtToken),
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
