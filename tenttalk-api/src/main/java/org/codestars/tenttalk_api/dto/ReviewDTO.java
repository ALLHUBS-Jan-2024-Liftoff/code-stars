package org.codestars.tenttalk_api.dto;

import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Tag;
import org.codestars.tenttalk_api.models.User;

import java.util.List;

public class ReviewDTO {
    
    private Long id;
    private String feedback;
    private int rating;
    private Campground campground;
    private User user;
    private List<Tag> tags;
    

    public ReviewDTO(Long id, String feedback, int rating, Campground campground, User user, List<Tag> tags){
        this.id = id;
        this.feedback = feedback;
        this.rating = rating;
        this.campground = campground;
        this.user = user;
        this.tags = tags;
    }

    public ReviewDTO() {}

    public String getFeedback() {
        return feedback;
    }

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

    public List<Tag> getTag() {
        return tags;
    }

    public void setTag(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    }



