package org.codestars.tenttalk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class User extends AbstractEntity {
    @NotBlank(message = "Email is required")
    @Email(message = "Must be valid Email")
    private String email;

    @OneToMany
    private List<Campground> favorites;

    public User (String email, List<Campground> favorites) {

        this.email = email;
        this.favorites = favorites;
    }

    public User(){};

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Campground> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Campground> favorites) {
        this.favorites = favorites;
    }
}

