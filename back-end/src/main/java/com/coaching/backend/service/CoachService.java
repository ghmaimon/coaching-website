package com.coaching.backend.service;

import com.coaching.backend.model.Coach;
import com.coaching.backend.repository.CoachRepository;
import org.springframework.stereotype.Service;

@Service
public class CoachService extends UserService<Coach>{
    public CoachService(CoachRepository coachRepository) {
        super(coachRepository);
    }
}
