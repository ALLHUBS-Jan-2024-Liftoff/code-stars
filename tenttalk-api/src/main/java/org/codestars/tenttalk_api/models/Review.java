package org.codestars.tenttalk_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Review extends AbstractEntity {

    private String comments;
    private int rating;

    @ManyToOne(/*MAPPEDBY STATEMENT*/fetch = FetchType.EAGER)
    @JoinColumn(name = "campground_id")
    private Campground campground;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "comments_tags")
    private List<Tag> tags;

    public Review(String comments, int rating, Campground campground, User user, List<Tag> tags) {

        this.comments = comments;
        this.rating = rating;
        this.campground = campground;
        this.user = user;
        this.tags = tags;
    }

    public Review(){};

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setReview(String comments) {
        this.comments = comments;
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
