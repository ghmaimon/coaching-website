package com.coaching.backend.controller.controller;

import com.coaching.backend.DTO.dataDTO.CoachNotVDTO;
import com.coaching.backend.model.Coach;
import com.coaching.backend.service.CoachService;
import com.coaching.backend.service.SuperUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/verifyCoach")
    public ResponseEntity<Void> verifyCoach(@RequestHeader("coach_id") long coach_id) {
        return new ResponseEntity<>(
                coachService.verifyCoach(coach_id)
        );
    }

    @GetMapping("/listNotVerified")
    public ResponseEntity<List<CoachNotVDTO>> listNotVerified() {
        return new ResponseEntity<>(
                coachService.listNotVerified(),
                HttpStatus.OK
        );
    }
}
