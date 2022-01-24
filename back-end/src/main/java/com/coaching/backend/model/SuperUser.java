package com.coaching.backend.model;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.SuperUserAuthorities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class SuperUser extends User{

    @ElementCollection(targetClass = SuperUserAuthorities.class)
    @Column(name = "authorities", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<SuperUserAuthorities> authorities;

    public SuperUser(String first_name, String last_name, Date birth_date,
                     String email, String password,
                     List<SuperUserAuthorities> authorities) {
        super(first_name, last_name, birth_date, Role.SUPERUSER, email, password);
        this.authorities = authorities;
    }

    public SuperUser() {}

    public List<SuperUserAuthorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SuperUserAuthorities> authorities) {
        this.authorities = authorities;
    }
}
