package org.codestars.tenttalk_api.controllers;


import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampgroundController {
    //@ResponseMapping Handles Both & Can be applied to the Entire Class
    //@PostMapping Handles Post

    @Autowired
    private CampgroundRepository campgroundRepository;

    @GetMapping("createCampground")
    public String createCamp(){
        return "Tent";
    }

    @GetMapping("createReview")
    public String createReview() {
        return "No Bears Allowed";
    }

}
