package com.coaching.backend.service;

import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.Coach;
import com.coaching.backend.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService{
    protected CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAllUsers(){
        return coachRepository.findAll();
    }

    public Coach getUserWithId(long id) {
        return coachRepository.findById(id).orElseThrow( () ->  new UserNotFoundException(id));
    }

    public Coach getUserWithEmail(String email) {
        return coachRepository.findByEmail(email).orElseThrow( () ->  new UserNotFoundException(email));
    }

    public List<Coach> getUsersWithName(String first_name, String last_name) {
        return coachRepository.findByFirstNameAndLastName(first_name, last_name);
    }
}
