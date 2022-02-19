package com.coaching.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CoachIsNotVerifiedException extends UserException {
    public CoachIsNotVerifiedException(String email) {
        super(CoachIsNotVerifiedException.class.getSimpleName()," coach is calling a method that requires the coach to be verified");
    }
}
