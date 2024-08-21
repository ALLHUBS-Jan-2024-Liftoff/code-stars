package org.codestars.tenttalk_api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Favorite> favoriteCampsites;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Review> reviews = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User() {}

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = encoder.encode(password);
        //this.favoriteCampsites = favoriteCampsites;
    }

    public void addToFavorite(Favorite favorite){
        favoriteCampsites.add(favorite);
        favorite.setUser(this);
    }

    public void removeFromFavorite(Favorite favorite) {
        favoriteCampsites.remove(favorite);
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
        this.password = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, this.password);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    //    public List<Favorite> getFavoriteCamps() {
//        return favoriteCampsites;
//    }
//
//    public void setFavoriteCamps(List<Favorite> favoriteCampsites) {
//        this.favoriteCampsites = favoriteCampsites;
//    }
}

