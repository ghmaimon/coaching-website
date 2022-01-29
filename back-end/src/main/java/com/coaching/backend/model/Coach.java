package com.coaching.backend.model;

import com.coaching.backend.enumeration.Level;
import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.Speciality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Coach extends User{

    private boolean verified = false;

    @ElementCollection(targetClass = Speciality.class)
    @JoinTable(name = "specialities", joinColumns = @JoinColumn(name = "ID"))
    @Column(name = "specialities")
    @NotNull(message = "Speciality is required")
    @Enumerated(EnumType.STRING)
    private List<Speciality> specialities;

    @Enumerated(EnumType.STRING)
    private Level level;

    public Coach(String first_name, String last_name, Date birth_date,
                 String email, String password,
                 boolean verified, List<Speciality> specialities, Level level) {
        super(first_name, last_name, birth_date, Role.COACH, email, password);
        this.verified = verified;
        this.specialities = specialities;
        this.level = level;
    }

    public Coach() {}

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
