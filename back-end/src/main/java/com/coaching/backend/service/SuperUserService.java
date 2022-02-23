package com.coaching.backend.service;

import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.SuperUser;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.SuperUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class SuperUserService extends UserService<SuperUser> {
    public SuperUserService(SuperUserRepository superUserRepository, EmailSenderService emailSenderService, PasswordEncoder passwordEncoder) {
        super(superUserRepository, emailSenderService, passwordEncoder);
    }
}
