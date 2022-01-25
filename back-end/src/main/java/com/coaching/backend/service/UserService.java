package com.coaching.backend.service;

import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.UserRepository;
import com.coaching.backend.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService<T extends User> {
    protected UserRepository<T> userRepository;
    protected PasswordEncoder passwordEncoder;

    public UserService(UserRepository<T> userRepository) {
        this.userRepository = userRepository;
        passwordEncoder = SecurityConfiguration.passwordEncoder();
    }

    public List<T> getAllUsers(){
        return this.userRepository.findAll();
    }

    public T getUserWithId(long id) throws Throwable{
        return (T) this.userRepository.findById(id).orElseThrow( () ->  new UserNotFoundException(id));
    }

    public T getUserWithEmail(String email) throws Throwable{
        return (T) this.userRepository.findByEmail(email).orElseThrow( () ->  new UserNotFoundException(email));
    }

    public List<T> getUsersWithName(String first_name, String last_name) throws Throwable{
        return this.userRepository.findByFirstNameAndLastName(first_name, last_name);
    }

    public T createUser(T user) throws Throwable{
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return (T) this.userRepository.save(user);
    }
}