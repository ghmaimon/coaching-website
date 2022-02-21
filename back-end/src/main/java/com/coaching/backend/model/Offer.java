package com.coaching.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.List;
@SuppressWarnings("unused")
@Entity
@Indexed
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coach_id")
    @NotNull(message = "Coach is required")
    private Coach coach;

    @ElementCollection
    private List<String> tags;

    @Field(termVector = TermVector.YES)
    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Description is required")
    private String description;

    private long minPrice;

    private long maxPrice;

    // I removed the notNull condition when i added the second constructor
    // @NotNull(message = "Creation date is required")
    private Date creationDate;

    public Offer() {}

    public Offer(Coach coach, List<String> tags, String title, String description, long minPrice, long maxPrice, Date creationDate) {
        this.coach = coach;
        this.tags = tags;
        this.title = title;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.creationDate = creationDate;
    }

    /**
     * doesnt require the creation date attribute, as it will be set automatically to today's date
     * @param coach coach
     * @param tags offer's tags
     * @param title offer's title
     * @param description offer's description
     * @param minPrice offer's minPrice
     * @param maxPrice offer's maxPrice
     */
    public Offer(Coach coach, List<String> tags, String title, String description, long minPrice, long maxPrice) {
        this.coach = coach;
        this.tags = tags;
        this.title = title;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.creationDate = Date.from(Instant.now());
    }

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

    public long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(long minPrice) {
        this.minPrice = minPrice;
    }

    public long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
}
