package com.coaching.backend.service;

import com.coaching.backend.enumeration.CoachDocuments;
import com.coaching.backend.exception.CoachNotFoundException;
import com.coaching.backend.exception.UserNotFoundException;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Offer;
import com.coaching.backend.repository.CoachRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Service
@Transactional

public class CoachService extends UserService<Coach>{
    public CoachService(CoachRepository coachRepository, EmailSenderService emailSenderService, PasswordEncoder passwordEncoder) {
        super(coachRepository, emailSenderService, passwordEncoder);
    }

    public boolean exists(Coach coach) {
        if (Objects.isNull(coach)) {
            return false;
        }
        return userRepository.existsById(coach.getId());
    }
    public Coach findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public Coach findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void setCoachDocument(@NotNull Coach coach, @NotNull CoachDocuments coachDocument,@NotNull String documentPath) {
        if (coachDocument == CoachDocuments.IDENTITY_DOCUMENT) {
            coach.setIdentityDocument(documentPath);
        }else if (coachDocument == CoachDocuments.COACHING_CERTIFICATE) {
            coach.setCoachingCertificate(documentPath);
        }else if (coachDocument == CoachDocuments.IMAGE){
            coach.setImage(documentPath);
        }else {
            throw new IllegalArgumentException("Invalid document type");
        }
        userRepository.save(coach);
    }
}
