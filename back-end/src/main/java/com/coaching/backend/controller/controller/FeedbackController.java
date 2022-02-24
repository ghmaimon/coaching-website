package com.coaching.backend.controller.controller;

import com.coaching.backend.DTO.dataDTO.FeedbackDTO;
import com.coaching.backend.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/create")
    public ResponseEntity<FeedbackDTO> addFeedback(@RequestBody FeedbackDTO feedbackDTO,
                                                @RequestHeader("Authorization") String jwtToken) {
        return new ResponseEntity<>(
                this.feedbackService.createFeedBack(feedbackDTO, jwtToken),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/list/byCoach")
    public ResponseEntity<List<FeedbackDTO>> listFeedbacksByCoach(@RequestHeader long id_coach) {
        return new ResponseEntity<>(
                this.feedbackService.listByCoach(id_coach),
                HttpStatus.OK
        );
    }


}
