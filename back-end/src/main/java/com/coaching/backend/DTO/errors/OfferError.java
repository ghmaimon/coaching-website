package com.coaching.backend.DTO.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@JsonFormat
public record OfferError(
        HttpStatus status,
        //change GMT+1 to GMT if not summer
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "GMT+1")
        Instant timestamp,
        ExceptionJsonFormatter exception
) {
}
