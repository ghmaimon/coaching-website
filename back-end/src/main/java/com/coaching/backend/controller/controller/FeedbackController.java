package com.coaching.backend.controller.controller;

import com.coaching.backend.model.Feedback;
import com.coaching.backend.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    FeedbackService feedbackService;

    @PostMapping("/create")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback,
                                                @RequestHeader String jwtToken) {
        return new ResponseEntity<>(
                this.feedbackService.createFeedBack(feedback, jwtToken),
                HttpStatus.CREATED
        );
    }


}
