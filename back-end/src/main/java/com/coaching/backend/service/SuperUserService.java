package com.coaching.backend.service;

import com.coaching.backend.exception.CoachNotFoundException;
import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.SuperUser;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.SuperUserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class SuperUserService extends UserService<SuperUser> {
    public SuperUserService(SuperUserRepository superUserRepository, EmailSenderService emailSenderService, PasswordEncoder passwordEncoder) {
        super(superUserRepository, emailSenderService, passwordEncoder);
    }

    public SuperUser findCurrentSuperUser() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<SuperUser> admin = userRepository.findByEmail(email);
        if (admin.isPresent())
            return admin.get();
        throw new UserNotFoundException(email);
    }
}
