package org.codestars.tenttalk_api.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {
    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    private List<Favorite> favoriteCampsites = new ArrayList<>();

    public User() {}

    public User(String email, String username, String password, List<Favorite> favoriteCampsites) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.favoriteCampsites = favoriteCampsites;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Favorite> getFavoriteCamps() {
        return favoriteCampsites;
    }

    public void setFavoriteCamps(List<Favorite> favoriteCampsites) {
        this.favoriteCampsites = favoriteCampsites;
    }
}

