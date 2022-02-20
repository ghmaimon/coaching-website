package com.coaching.backend.service;

import com.coaching.backend.exception.CoachNotFoundException;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Offer;
import com.coaching.backend.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Coach findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public Coach findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Offer> findAllOffersByCoachId(long id) {
        Coach coach = userRepository.findById(id).orElse(null);
        if (coach == null) throw new CoachNotFoundException(id);
        return coach.getOffers();
    }

    public List<Offer> findAllOffersByCoachFirstAndLastName(String firstName, String lastName) {
        return null;
    }
}
