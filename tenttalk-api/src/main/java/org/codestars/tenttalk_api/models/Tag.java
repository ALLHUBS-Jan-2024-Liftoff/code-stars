package org.codestars.tenttalk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Tag extends AbstractEntity {

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Campground> campgrounds;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
