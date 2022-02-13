package com.coaching.backend.repository;

import com.coaching.backend.model.TrainingContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingContractRepository extends JpaRepository<TrainingContract, Long> {
}
