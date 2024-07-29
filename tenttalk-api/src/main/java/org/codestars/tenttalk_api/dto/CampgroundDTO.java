package org.codestars.tenttalk_api.dto;

import org.codestars.tenttalk_api.models.AbstractEntity;

public class CampgroundDTO {
    private Long id;
    private String name;
    private String address;
    private String website;
    private String placeId;
    private int rating;

    public CampgroundDTO(Long id, String name, String address, String website, String placeId, int rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.website = website;
        this.placeId = placeId;
        this.rating = rating;
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

    public void setId(Long id) {
        this.id = id;
    }
}
