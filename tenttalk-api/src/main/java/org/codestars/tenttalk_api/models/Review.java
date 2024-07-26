package org.codestars.tenttalk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Review extends AbstractEntity {

    private String feedback;

    private int rating;

    @ManyToOne
    private Campground campground;

    @ManyToOne
    //@NotNull(message = "")
    private User user;

    @ManyToMany
    private List<Tag> tags;

    public Review(String feedback, int rating, Campground campground, User user, List<Tag> tags) {

        this.feedback = feedback;
        this.rating = rating;
        this.campground = campground;
        this.user = user;
        this.tags = tags;
    }



    public Review(){};

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Campground getCampground() {
        return campground;
    }

    public void setCampground(Campground campground) {
        this.campground = campground;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
