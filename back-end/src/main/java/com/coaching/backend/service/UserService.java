package com.coaching.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.coaching.backend.exception.UserAlreadyExistsException;
import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.UserRepository;
import com.coaching.backend.security.JwtProperties;
import com.coaching.backend.security.SecurityConfiguration;
import org.springframework.http.HttpStatus;
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

    public T getUserWithId(long id) {
        return (T) this.userRepository.findById(id).orElseThrow( () ->  new UserNotFoundException(id));
    }

    public T getUserWithEmail(String email){
        return (T) this.userRepository.findByEmail(email).orElseThrow( () ->  new UserNotFoundException(email));
    }

    public List<T> getUsersWithName(String first_name, String last_name){
        return this.userRepository.findByFirstNameAndLastName(first_name, last_name);
    }

    public T createUser(T user){
        if (userRepository.existsByEmail(user.getEmail())) throw new UserAlreadyExistsException(user.getEmail());
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return (T) this.userRepository.save(user);
    }

    public HttpStatus deleteUserWithToken(String jwtToken) {
        jwtToken = jwtToken.replace(JwtProperties.TOKEN_PREFIX, "");
        String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
                .build()
                .verify(jwtToken)
                .getSubject();
        deleteUserWithEmail(email);
        return HttpStatus.OK;
    }

    public void deleteUserWithId(long id) {
        userRepository.deleteById(id);
    }

    public void deleteUserWithEmail(String email) {
        T user = getUserWithEmail(email);
        userRepository.deleteById(user.getId());
    }
}