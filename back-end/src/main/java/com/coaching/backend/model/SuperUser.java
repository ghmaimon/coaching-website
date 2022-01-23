package com.coaching.backend.model;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.SuperUserAuthorities;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;

public class SuperUser extends User{

    @Type(type = "json")
    private List<SuperUserAuthorities> authorities;

    public SuperUser(String first_name, String last_name, Date birth_date,
                     Role role, String email, String password,
                     List<SuperUserAuthorities> authorities) {
        super(first_name, last_name, birth_date, role, email, password);
        this.authorities = authorities;
    }

    public List<SuperUserAuthorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SuperUserAuthorities> authorities) {
        this.authorities = authorities;
    }
}
