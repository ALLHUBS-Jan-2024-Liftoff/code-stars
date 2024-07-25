package org.codestars.tenttalk_api.controllers;


import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.codestars.tenttalk_api.service.CampgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campground")
@CrossOrigin
public class CampgroundController {

    @Autowired
    private CampgroundService campgroundService;

    @PostMapping("/add")
    public String addCampground(@RequestBody Campground campground){
        campgroundService.saveCampground(campground);
        return "New Campground Added";
    }

//    @GetMapping("/getAll")
//    public List<Campground> getAllCampgrounds(){
//        return campgroundService.getAllCampgrounds();
//    }

}
