package com.coaching.backend.service;

import com.coaching.backend.exception.OfferNotFoundException;
import com.coaching.backend.model.Client;
import com.coaching.backend.model.Contract;
import com.coaching.backend.repository.ContractRepository;
import com.coaching.backend.security.JwtLogin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional

public class ContractService<T extends Contract> {

    ContractRepository<T> contractRepository;
    ClientService clientService;
    public ContractService(ContractRepository<T> contractRepository,  ClientService clientService) {
        this.contractRepository = contractRepository;
        this.clientService = clientService;
    }

    public T createContract(T contract, String jwtToken) {
        if (contract.getOffer() == null) throw new OfferNotFoundException("422", "offer was not given");
        String email = JwtLogin.getEmailFromJwtToken(jwtToken);
        Client user = clientService.getUserWithEmail(email);
        contract.setClient(user);
        contract.setAcceptanceDate(new Date());
        contract.setPaid(false);
        return contractRepository.save(contract);
    }
}