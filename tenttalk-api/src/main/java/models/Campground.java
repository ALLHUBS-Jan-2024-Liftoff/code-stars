package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Campground {
   @Id
   @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String placeId;
    private int rating;

    private List<Review> reviews;
    private List<Tag> tags;


    public Campground(int id, String name, String address, String placeId, int rating, List<Review> reviews, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.placeId = placeId;
        this.rating = rating;
        this.reviews = reviews;
        this.tags = tags;
    }

    public Campground(){};


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
