package com.coaching.backend.model;

import com.coaching.backend.enumeration.CoachDocuments;
import com.coaching.backend.enumeration.Level;
import com.coaching.backend.enumeration.Role;
import com.coaching.backend.enumeration.Speciality;
import com.coaching.backend.utils.FileConfig;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * path to id card
     */
    private String identityDocument;
    /**
     * path to coaching certificate
     */
    private String coachingCertificate ;
    /**
     * path to image of coach
     */
    private String image;

    public Coach(String firstName, String lastName, Date birth_date, Role role, String email, String password, boolean verified, List<Speciality> specialities, Level level, String identityDocument, String coachingCertificate, String image) {
        super(firstName, lastName, birth_date, role, email, password);
        this.verified = verified;
        this.specialities = specialities;
        this.level = level;
        this.identityDocument = identityDocument;
        this.coachingCertificate = coachingCertificate;
        this.image = image;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getCoachingCertificate() {
        return coachingCertificate;
    }

    public void setCoachingCertificate(String coachingCertificate) {
        this.coachingCertificate = coachingCertificate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
