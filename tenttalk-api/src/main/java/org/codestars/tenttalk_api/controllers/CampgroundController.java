package org.codestars.tenttalk_api.controllers;


import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampgroundController {

    @Autowired
    private CampgroundRepository campgroundRepository;

    @PostMapping("/campgrounds")
    public Campground saveCampground(){

        return campgroundRepository.saveCampground();
    }

}
