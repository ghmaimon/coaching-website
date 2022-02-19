package com.coaching.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(UserControllerAdvice.class);

}
