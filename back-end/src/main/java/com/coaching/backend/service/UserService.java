package com.coaching.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.coaching.backend.exception.*;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.UserRepository;
import com.coaching.backend.security.JwtChangePassword;
import com.coaching.backend.security.JwtLogin;
import com.coaching.backend.security.JwtProperties;
import com.coaching.backend.security.SecurityConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UserService<T extends User> {
    protected UserRepository<T> userRepository;
    protected PasswordEncoder passwordEncoder;
    protected EmailSenderService emailSenderService;

    public UserService(UserRepository<T> userRepository, EmailSenderService emailSenderService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailSenderService = emailSenderService;
        this.passwordEncoder = passwordEncoder;
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
        String email = JwtLogin.getEmailFromJwtToken(jwtToken);
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

    public HttpStatus changePasswordFromToken(String jwtToken, JwtChangePassword jwtChangePassword) {
        String email = JwtLogin.getEmailFromJwtToken(jwtToken);
        T user = getUserWithEmail(email);
        if (!passwordEncoder.matches(jwtChangePassword.getOldPass(), user.getPassword()))
            throw new WrongPasswordException(jwtChangePassword.getOldPass());
        return changePassword(jwtChangePassword, user);
    }

    public HttpStatus changePasswordById(long id, JwtChangePassword jwtChangePassword) {
        T user = getUserWithId(id);
        return changePassword(jwtChangePassword, user);
    }

    private HttpStatus changePassword(JwtChangePassword jwtChangePassword, T user) {
        if (!jwtChangePassword.getNewPass1().equals(jwtChangePassword.getNewPass2()))
            throw new PasswordsUnmatchedException(jwtChangePassword.getNewPass1(), jwtChangePassword.getNewPass2());
        user.setPassword(passwordEncoder.encode(jwtChangePassword.getNewPass1()));
        userRepository.save(user);
        return HttpStatus.OK;
    }

    public HttpStatus forgotPassword(String email) {
        // this function will send an email with the link to create new password
        Optional<T> userOpt =  userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            emailSenderService.sendSimpleEmail(
                    user.getEmail(),
                    "here's the link to change your password : http://localhost:3000/NewPassword/" + user.getId(),
                    "Change password in Coaching website"
            );
        }
        return  HttpStatus.OK;
    }
}