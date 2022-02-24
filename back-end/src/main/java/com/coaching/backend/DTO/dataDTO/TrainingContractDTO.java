package com.coaching.backend.DTO.dataDTO;

public record TrainingContractDTO(
        long id,
        long offer_id,
        String offer_title,
        long client_id,
        String client_name,
        long price,
        boolean paid,
        long duration,
        long days_in_week,
        long hours_in_day
){
}
