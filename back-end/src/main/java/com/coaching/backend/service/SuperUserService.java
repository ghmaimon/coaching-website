package com.coaching.backend.service;

import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.SuperUser;
import com.coaching.backend.repository.SuperUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperUserService{
    protected SuperUserRepository superUserRepository;

    public SuperUserService(SuperUserRepository superUserRepository) {
        this.superUserRepository = superUserRepository;
    }

    public List<SuperUser> getAllUsers(){
        return superUserRepository.findAll();
    }

    public SuperUser getUserWithId(long id) {
        return superUserRepository.findById(id).orElseThrow( () ->  new UserNotFoundException(id));
    }

    public SuperUser getUserWithEmail(String email) {
        return superUserRepository.findByEmail(email).orElseThrow( () ->  new UserNotFoundException(email));
    }

    public List<SuperUser> getUsersWithName(String first_name, String last_name) {
        return superUserRepository.findByFirstNameAndLastName(first_name, last_name);
    }

    public SuperUser createSuperUser(SuperUser superUser){
        return superUserRepository.save(superUser);
    }
}
