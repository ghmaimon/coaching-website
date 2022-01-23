package com.coaching.backend.model;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.Speciality;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;

public class Client extends User{

    @Type(type = "json")
    private List<Speciality> interests;

    public Client(String first_name, String last_name, Date birth_date,
                  Role role, String email, String password,
                  List<Speciality> interests) {
        super(first_name, last_name, birth_date, role, email, password);
        this.interests = interests;
    }

    public List<Speciality> getInterests() {
        return interests;
    }

    public void setInterests(List<Speciality> interests) {
        this.interests = interests;
    }
}
