package com.coaching.backend.controller;

import com.coaching.backend.errors.UserError;
import com.coaching.backend.exception.CoachIsNotVerifiedException;
import com.coaching.backend.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

import static com.coaching.backend.errors.ExceptionJsonFormatter.convertExceptionToJson;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerAdvice implements MyControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(UserControllerAdvice.class);


}
