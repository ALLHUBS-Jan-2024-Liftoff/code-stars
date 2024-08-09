package org.codestars.tenttalk_api.models;


import jakarta.persistence.Entity;

@Entity
public class Favorite extends AbstractEntity {

private Campground campground;

private User user;

    public Favorite(Campground campground, User user) {
        this.campground = campground;
        this.user = user;
    }

    public Favorite(){}

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

    //spent 8.5 hrs trying to make favorites abstract and failed t(-_-)t
    //Doing it the boring way.
}
