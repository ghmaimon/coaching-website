package com.coaching.backend.controller.controllerAdvice;

import com.coaching.backend.DTO.errorDTO.UserError;
import com.coaching.backend.exception.GeneralException;
import com.coaching.backend.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

import static com.coaching.backend.DTO.errorDTO.ExceptionJsonFormatter.convertExceptionToJson;

public interface UserControllerAdvice extends ControllerAdvice{
    default <E extends GeneralException> ResponseEntity<UserError> handleUserException(
            int statusCode, E exception) {

        LOG.debug("error response {}", exception.getMessage());
        UserError err = new UserError(
                HttpStatus.resolve(statusCode),
                Instant.now(),
                convertExceptionToJson(exception)
        );
        return ResponseEntity
                .status(statusCode)
                .body(err);
    }
}
