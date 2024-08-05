package org.codestars.tenttalk_api.dto;

import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.User;

import java.util.List;

public class FavoriteDTO {

    private Long id;
    private User user;
    private List<Campground> favoriteCampgrounds;

    public FavoriteDTO(Long id, User user, List<Campground> favoriteCampgrounds) {
        this.id = id;
        this.user = user;
        this.favoriteCampgrounds = favoriteCampgrounds;
    }

    public FavoriteDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Campground> getFavoriteCampgrounds() {
        return favoriteCampgrounds;
    }

    public void setFavoriteCampgrounds(List<Campground> favoriteCampgrounds) {
        this.favoriteCampgrounds = favoriteCampgrounds;
    }
}
