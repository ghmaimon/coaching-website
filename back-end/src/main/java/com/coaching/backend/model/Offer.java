package com.coaching.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    @NotNull(message = "Coach is required")
    private Coach coach;

    @ElementCollection
    private List<String> tags;

    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Description is required")
    private String description;

    private long price;

    @NotNull(message = "Creation date is required")
    private Date creation_date;

    public Offer(Coach coach, List<String> tags, String title, String description, long price, Date creation_date) {
        this.coach = coach;
        this.tags = tags;
        this.title = title;
        this.description = description;
        this.price = price;
        this.creation_date = creation_date;
    }

    public Offer() {}

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Long getId() {
        return id;
    }
}
