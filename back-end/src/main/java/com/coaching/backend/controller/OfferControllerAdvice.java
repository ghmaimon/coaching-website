package com.coaching.backend.controller;

import com.coaching.backend.errors.UserError;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = OfferController.class)
public class OfferControllerAdvice implements MyControllerAdvice{
    @ExceptionHandler(CoachIsNotVerifiedException.class)
    public ResponseEntity<UserError> handleException(
            CoachIsNotVerifiedException exception
    ) {
        return handleUserException(HttpStatus.BAD_REQUEST.value(), exception);
    }
}
