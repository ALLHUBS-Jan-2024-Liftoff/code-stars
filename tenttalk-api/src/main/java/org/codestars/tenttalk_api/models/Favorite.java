package org.codestars.tenttalk_api.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Favorite extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "campground_id")
    private Campground campgrounds;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Favorite(Campground campground, User user) {
        this.campgrounds = campground;
        this.user = user;
    }

    public Favorite(){}

    public Campground getCampground() {
        return campgrounds;
    }

    public void setCampground(Campground campground) {
        this.campgrounds = campground;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //spent 8.5 hrs trying to make favorites polymorphic and failed t(-_-)t
    //Doing it the boring way.
}
