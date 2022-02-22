package com.coaching.backend.controller.controllerAdvice.implementation;

import com.coaching.backend.controller.controller.ContractController;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = ContractController.class)
public class ContractControllerAdvice {

}
