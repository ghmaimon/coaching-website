package com.coaching.backend.model;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.Speciality;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Client extends User{

    @ElementCollection(targetClass = Speciality.class)
    @Column(name = "interests")
    @Enumerated(EnumType.STRING)
    private List<Speciality> interests;

    public Client(String first_name, String last_name, Date birth_date,
                  String email, String password,
                  List<Speciality> interests) {
        super(first_name, last_name, birth_date, Role.CLIENT, email, password);
        this.interests = interests;
    }

    public Client() {}

    public List<Speciality> getInterests() {
        return interests;
    }

    public void setInterests(List<Speciality> interests) {
        this.interests = interests;
    }
}
