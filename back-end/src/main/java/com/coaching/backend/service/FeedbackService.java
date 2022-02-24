package com.coaching.backend.service;
import com.coaching.backend.DTO.dataDTO.FeedbackDTO;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.Feedback;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.FeedbackRepository;
import com.coaching.backend.security.JwtLogin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    FeedbackRepository feedbackRepository;
    UserService userService;
    CoachService coachService;

    public FeedbackService(FeedbackRepository feedbackRepository,
                           UserService userService,
                           CoachService coachService
    ) {
        this.feedbackRepository = feedbackRepository;
        this.userService = userService;
        this.coachService = coachService;
    }

    public FeedbackDTO createFeedBack(FeedbackDTO feedbackDTO, String jwtToken) {
        Feedback feedback = new Feedback();
        feedback.setComment(feedbackDTO.comment());
        feedback.setStars(feedbackDTO.stars());
        User rated = userService.getUserWithId(feedbackDTO.rated_id());
        feedback.setRated(rated);
        String email = JwtLogin.getEmailFromJwtToken(jwtToken);
        User rater = userService.getUserWithEmail(email);
        feedback.setRater(rater);
        Feedback sfeedback =  this.feedbackRepository.save(feedback);
        return new FeedbackDTO(sfeedback.getRated().getId(),
                sfeedback.getRated().getLastName() + " " + sfeedback.getRated().getLastName(),
                sfeedback.getRater().getId(),
                sfeedback.getRater().getLastName() + " " + sfeedback.getRater().getLastName(),
                sfeedback.getStars(),
                sfeedback.getComment());
    }

    public List<FeedbackDTO> listByCoach(long id_coach) {
        Coach rated = coachService.getUserWithId(id_coach);
        return feedbackRepository.findFeedbackByRated(rated).stream().map(
                (Feedback f) -> {
                    return new FeedbackDTO(f.getRated().getId(),
                            f.getRated().getLastName() + " " + f.getRated().getLastName(),
                            f.getRater().getId(),
                            f.getRater().getLastName() + " " + f.getRater().getLastName(),
                            f.getStars(),
                            f.getComment());
                }
        ).toList();
    }
}
