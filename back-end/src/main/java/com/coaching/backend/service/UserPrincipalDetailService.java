package com.coaching.backend.service;

import com.coaching.backend.model.User;
import com.coaching.backend.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class UserPrincipalDetailService implements UserDetailsService {
    private UserService userService;

    public UserPrincipalDetailService( UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = null;
        try {
            user = userService.getUserWithEmail(email);
            user.setActive(true);
        } catch (Throwable e) {}
        if (user == null) throw new UsernameNotFoundException(email);
        return new UserPrincipal(user);
    }
}
