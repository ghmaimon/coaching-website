package com.coaching.backend.service;

import com.coaching.backend.model.MealContract;
import com.coaching.backend.repository.ContractRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class MealContractService extends ContractService<MealContract> {
    public MealContractService(ContractRepository<MealContract> contractRepository) {
        super(contractRepository);
    }
}
