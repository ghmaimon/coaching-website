package com.coaching.backend.controller.controller;

import com.coaching.backend.service.SuperUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/account")
public class SuperUserController {

    SuperUserService superUserService;

    public SuperUserController(SuperUserService superUserService) {
        this.superUserService = superUserService;
    }

    p
}
