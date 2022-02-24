package com.coaching.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rater_id")
    @NotNull(message = "Rater is required")
    private User rater;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rated_id")
    @NotNull(message = "Rated is required")
    private User rated;

    @NotNull(message = "Stars is required")
    private int stars;

    private String comment;

    public long getId() {
        return id;
    }

    public User getRater() {
        return rater;
    }

    public void setRater(User rater) {
        this.rater = rater;
    }

    public User getRated() {
        return rated;
    }

    public void setRated(User rated) {
        this.rated = rated;
    }

    public int getStars() { return stars; }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
