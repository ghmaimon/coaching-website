package com.coaching.backend.model;

import com.coaching.backend.enumeration.Level;
import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.Speciality;
import org.hibernate.annotations.Type;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

public class Coach extends User{

    private boolean verified = false;

    @Type(type = "json")
    private List<Speciality> specialities;

    @Enumerated(EnumType.STRING)
    private Level level;

    public Coach(String first_name, String last_name, Date birth_date,
                 Role role, String email, String password,
                 boolean verified, List<Speciality> specialities, Level level) {
        super(first_name, last_name, birth_date, role, email, password);
        this.verified = verified;
        this.specialities = specialities;
        this.level = level;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
