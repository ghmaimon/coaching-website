package com.coaching.backend.controller.controllerAdvice;

import com.coaching.backend.errors.OfferError;
import com.coaching.backend.errors.UserError;
import com.coaching.backend.exception.OfferException;
import com.coaching.backend.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

import static com.coaching.backend.errors.ExceptionJsonFormatter.convertExceptionToJson;

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
