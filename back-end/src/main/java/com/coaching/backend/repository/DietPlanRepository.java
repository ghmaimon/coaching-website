package com.coaching.backend.repository;

import com.coaching.backend.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
}
