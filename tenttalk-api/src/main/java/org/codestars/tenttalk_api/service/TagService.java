package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Campground;

import java.util.List;

public interface TagService {

    public Campground saveCampground(Campground campground);

    public List<Campground> getAllCampgrounds();


}
