package com.coaching.backend.service;

import com.coaching.backend.model.TrainingContract;
import com.coaching.backend.repository.ContractRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class TrainingContractService extends ContractService<TrainingContract> {
    public TrainingContractService(ContractRepository<TrainingContract> contractRepository) {
        super(contractRepository);
    }
}
