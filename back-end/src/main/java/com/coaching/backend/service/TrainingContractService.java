package com.coaching.backend.service;

import com.coaching.backend.model.TrainingContract;
import com.coaching.backend.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingContractService extends ContractService<TrainingContract> {
    public TrainingContractService(ContractRepository<TrainingContract> contractRepository) {
        super(contractRepository);
    }
}
