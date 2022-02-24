package com.coaching.backend.repository;


import com.coaching.backend.model.Feedback;
import com.coaching.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findFeedbackByRated(User rated);
}
