package com.coaching.backend.controller.controllerAdvice.implementation;

import com.coaching.backend.controller.controller.OfferController;
import com.coaching.backend.controller.controllerAdvice.OfferControllerAdvice;
import com.coaching.backend.DTO.errorDTO.OfferError;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
import com.coaching.backend.exception.OfferNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = OfferController.class)
public class OfferControllerAdviceImpl implements OfferControllerAdvice {
    @ExceptionHandler(CoachIsNotVerifiedException.class)
    public ResponseEntity<OfferError> handleException(
            OfferNotFoundException exception
    ) {
        return handleOfferException(HttpStatus.BAD_REQUEST.value(), exception);
    }
}
