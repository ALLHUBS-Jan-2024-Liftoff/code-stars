package org.codestars.tenttalk_api.controllers;


import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampgroundController {
    //@ResponseMapping Handles Both & Can be applied to the Entire Class
    //@PostMapping Handles Post

    @Autowired
    private CampgroundRepository campgroundRepository;

    @PostMapping("campground/create")
    public String createCamp(){
        //todo: method takes usersubmission and inserts into databse
        //todo: takes json -> java -> sql
        //todo: return response campgroundID or "Sucessfully Created"


        return "Campground sucessfully created";
    }

    @GetMapping("")
    public String findAllCampgrounds(){

        return "All Campgrounds";
    }



    //getAllCampgrounds
    //filter



}
