package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Review {
   @Id
   @GeneratedValue
    private int id;
    private String review;
    private int rating;
    private Campground campground;
    private User user;
    private List<Tag> tags;

    public Review(int id, String review, int rating, Campground campground, User user, List<Tag> tags) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.campground = campground;
        this.user = user;
        this.tags = tags;
    }

    public Review(){};

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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
