package org.codestars.tenttalk_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Tag extends AbstractEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Campground campground;

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
