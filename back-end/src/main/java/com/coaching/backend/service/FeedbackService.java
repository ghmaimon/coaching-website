package com.coaching.backend.service;
import com.coaching.backend.exception.UserNullException;
import com.coaching.backend.model.Feedback;
import com.coaching.backend.model.User;
import com.coaching.backend.repository.FeedbackRepository;
import com.coaching.backend.security.JwtLogin;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    FeedbackRepository feedbackRepository;
    UserService userService;

    public FeedbackService(FeedbackRepository feedbackRepository,
                           UserService userService
    ) {
        this.feedbackRepository = feedbackRepository;
        this.userService = userService;
    }

    public Feedback createFeedBack(Feedback feedback, String jwtToken) {
        if (feedback.getRated() == null) throw new UserNullException();
        String email = JwtLogin.getEmailFromJwtToken(jwtToken);
        User rater = userService.getUserWithEmail(email);
        feedback.setRater(rater);
        return this.feedbackRepository.save(feedback);
    }
}
