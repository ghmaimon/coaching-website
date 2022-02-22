package com.coaching.backend.controller.controllerAdvice.implementation;

import com.coaching.backend.controller.controller.UserController;
import com.coaching.backend.controller.controllerAdvice.UserControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerAdviceImpl implements UserControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(UserControllerAdviceImpl.class);

}
