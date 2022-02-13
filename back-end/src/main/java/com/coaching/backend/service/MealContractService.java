package com.coaching.backend.service;

import com.coaching.backend.model.MealContract;
import com.coaching.backend.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class MealContractService extends ContractService<MealContract> {
    public MealContractService(ContractRepository<MealContract> contractRepository) {
        super(contractRepository);
    }
}
