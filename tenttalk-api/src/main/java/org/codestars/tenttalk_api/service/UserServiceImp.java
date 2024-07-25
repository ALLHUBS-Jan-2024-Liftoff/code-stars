package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements CampgroundService {
    @Autowired
    private CampgroundRepository campgroundRepository;

    @Override
    public Campground saveCampground(Campground campground) {
        return campgroundRepository.save(campground);
    }

    @Override
    public List<Campground> getAllCampgrounds() {
        return campgroundRepository.findAll();
    }
}