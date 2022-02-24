package com.coaching.backend.service;

import com.coaching.backend.DTO.dataDTO.ClientDTO;
import com.coaching.backend.DTO.dataDTO.CoachDTO;
import com.coaching.backend.enumeration.CoachDocuments;
import com.coaching.backend.enumeration.Role;
import com.coaching.backend.model.Client;
import com.coaching.backend.model.Coach;
import com.coaching.backend.repository.CoachRepository;
import com.coaching.backend.security.JwtLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional

public class CoachService extends UserService<Coach>{

    CoachRepository coachRepository;
    private FileService fileService;

    public CoachService(CoachRepository coachRepository, EmailSenderService emailSenderService,
                        PasswordEncoder passwordEncoder, @Lazy FileService fileService) {
        super(coachRepository, emailSenderService, passwordEncoder);
        this.coachRepository = coachRepository;
        this.fileService = fileService;
    }

//    @Autowired
//    public void setFileService(FileService fileService) {
//        this.fileService = fileService;
//    }

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

    public List<ClientDTO> getCoachsClients(String jwtToken) {
        String email = JwtLogin.getEmailFromJwtToken(jwtToken);
        Coach coach = getUserWithEmail(email);
        return coachRepository.findClientByCoach(coach.getId()).stream().map(
                (Client c) -> {
                    return new ClientDTO(
                            c.getId(),
                            c.getFirstName() + " " + c.getLastName()
                    );
                }
        ).toList();
    }

    public Coach createCoach(CoachDTO coachDto) throws IOException, NoSuchAlgorithmException {
        Coach coach = new Coach(
                coachDto.firstName(),
                coachDto.lastName(),
                coachDto.birth_date(),
                Role.COACH,
                coachDto.email(),
                coachDto.password(),
                false,
                null,
                null,
                null,
                null,
                null
        );
        createUser(coach);
        fileService.uploadCoachDocuments(coach,coachDto.coachingCertificate(),CoachDocuments.COACHING_CERTIFICATE);
        fileService.uploadCoachDocuments(coach,coachDto.identityDocument(),CoachDocuments.IDENTITY_DOCUMENT);
        fileService.uploadCoachDocuments(coach,coachDto.image(),CoachDocuments.IMAGE);
        return coach;
    }

    public HttpStatus verifyCoach(long coach_id) {
        Coach coach = getUserWithId(coach_id);
        coach.setVerified(true);
        coachRepository.save(coach);
        return HttpStatus.OK;
    }
}
