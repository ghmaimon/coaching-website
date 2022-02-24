package com.coaching.backend.DTO.dataDTO;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record CoachDTO(
        @NotNull(message = "firstName must not be null")
        @NotEmpty(message = "firstName must not be an empty string")
         String firstName,
        @NotNull(message = "lastName must not be null")
        @NotEmpty(message = "lastName must not be an empty string")
         String lastName,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
         Date birth_date,
        @NotNull(message = "Email must not be null")
        @Column(name = "email", unique = true)
        @javax.validation.constraints.Email(message = "not an email")
         String email,
        @NotNull(message = "password must not be null")
        @NotEmpty(message = "password must not be an empty string")
         String password,
         MultipartFile identityDocument,
         MultipartFile coachingCertificate,
         MultipartFile image
) {
}
