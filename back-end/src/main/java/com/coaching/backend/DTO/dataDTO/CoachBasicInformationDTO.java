package com.coaching.backend.DTO.dataDTO;

import com.coaching.backend.model.Coach;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CoachBasicInformationDTO(
        long id,
        @NotNull(message = "firstName must not be null")
        @NotEmpty(message = "firstName must not be an empty string")
        String firstName,
        @NotNull(message = "lastName must not be null")
        @NotEmpty(message = "lastName must not be an empty string")
        String lastName,
        String email
) {
        public CoachBasicInformationDTO(Coach coach) {
                this(coach.getId(),coach.getFirstName(),coach.getLastName(), coach.getEmail());
        }

        public CoachBasicInformationDTO(long id, @NotNull(message = "firstName must not be null")
        @NotEmpty(message = "firstName must not be an empty string")
                String firstName, @NotNull(message = "lastName must not be null")
                                        @NotEmpty(message = "lastName must not be an empty string")
                                                String lastName, String email) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
        }
}
