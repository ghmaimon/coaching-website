package com.coaching.backend.service;

import com.coaching.backend.exception.OfferNotFoundException;
import com.coaching.backend.model.Contract;
import com.coaching.backend.repository.ContractRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ContractService<T extends Contract> {

    ContractRepository<T> contractRepository;
    public ContractService(ContractRepository<T> contractRepository) {
        this.contractRepository = contractRepository;
    }

    public T createContract(T contract) {
        if (contract.getOffer() == null) throw new OfferNotFoundException("422", "offer was not given");
        return contractRepository.save(contract);
    }
}