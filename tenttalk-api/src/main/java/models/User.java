package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class User {
   @Id
   @GeneratedValue
    private int id;
    private String email;
    private List<Campground> favorites;

    public User(int id, String email, List<Campground> favorites) {
        this.id = id;
        this.email = email;
        this.favorites = favorites;
    }

    public User(){};

    public int getId() {
        return id;
    }

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

