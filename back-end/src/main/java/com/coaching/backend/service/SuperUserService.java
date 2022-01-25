package com.coaching.backend.service;

import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.SuperUser;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.SuperUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperUserService extends UserService<SuperUser> {
    public SuperUserService(SuperUserRepository superUserRepository) {
        super(superUserRepository);
    }
}
