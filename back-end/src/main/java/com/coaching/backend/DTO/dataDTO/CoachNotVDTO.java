package com.coaching.backend.DTO.dataDTO;

public record CoachNotVDTO(
        long id_coach,
        String nom_coach,
        String certificate,
        String cin,
        String image
) {
}
