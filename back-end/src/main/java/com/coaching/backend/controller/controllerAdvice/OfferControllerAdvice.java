package com.coaching.backend.controller.controllerAdvice;

import com.coaching.backend.DTO.errorDTO.OfferError;
import com.coaching.backend.exception.OfferException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

import static com.coaching.backend.DTO.errorDTO.ExceptionJsonFormatter.convertExceptionToJson;

public interface OfferControllerAdvice extends ControllerAdvice{
    default <E extends OfferException> ResponseEntity<OfferError> handleOfferException(
            int statusCode, E exception) {

        LOG.debug("error response {}", exception.getMessage());
        OfferError err = new OfferError(
                HttpStatus.resolve(statusCode),
                Instant.now(),
                convertExceptionToJson(exception)
        );
        return ResponseEntity
                .status(statusCode)
                .body(err);
    }
}
