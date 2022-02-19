package com.coaching.backend.service;

import com.coaching.backend.model.Coach;
import com.coaching.backend.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CoachService extends UserService<Coach>{
    public CoachService(CoachRepository coachRepository) {
        super(coachRepository);
    }

    public boolean exists(Coach coach) {
        if (Objects.isNull(coach)) {
            return false;
        }
        return userRepository.existsById(coach.getId());
    }

    public Coach findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
