package com.coaching.backend.repository;

import com.coaching.backend.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository<T extends Contract> extends JpaRepository<T, Long> {
}
