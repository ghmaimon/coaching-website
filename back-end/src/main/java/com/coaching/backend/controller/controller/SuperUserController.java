package com.coaching.backend.controller.controller;

import com.coaching.backend.service.CoachService;
import com.coaching.backend.service.SuperUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/superuser")
public class SuperUserController {

    SuperUserService superUserService;
    CoachService coachService;

    public SuperUserController(SuperUserService superUserService,
                               CoachService coachService) {
        this.superUserService = superUserService;
        this.coachService = coachService;
    }

    @PostMapping("/verifyCoach")
    public ResponseEntity<Void> verifyCoach(@RequestHeader("coach_id") long coach_id) {
        return new ResponseEntity<>(
                coachService.verifyCoach(coach_id)
        );
    }
}
