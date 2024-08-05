package org.codestars.tenttalk_api.dto;

import org.codestars.tenttalk_api.models.AbstractEntity;
import org.codestars.tenttalk_api.models.Review;

import java.util.ArrayList;
import java.util.List;

public class CampgroundDTO {
    private Long id;
    private String name;
    private String address;
    private String website;
    private String placeId;
    private int rating;
    private List<Review> reviews = new ArrayList<>();

    public CampgroundDTO (Long id, String name, String address, String website, String placeId, int rating, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.website = website;
        this.placeId = placeId;
        this.rating = rating;
        this.reviews = reviews;
    }

    public CampgroundDTO(){}

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id){ this.id = id;}

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
