package com.coaching.backend.DTO.dataDTO;

public record FeedbackDTO (
    long rated_id,
    String rated,
    long rater_id,
    String rater,
    int stars,
    String comment
){}
