package com.coaching.backend.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.TermVector;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "users")
public class PublicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Field(termVector = TermVector.YES)
    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title should not be empty")
    private String title;

    @NotNull(message = "Description is required")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull(message = "Organizer is required")
    private User organizer;

    @NotNull(message = "Date is required")
    private Date date;

    /**
     * path to image of public event
     */
    private String image;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
