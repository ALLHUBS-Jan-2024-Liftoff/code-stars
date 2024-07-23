package org.codestars.tenttalk_api.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    @PostMapping("createReview")
    public String createReview() {
        //how to intake json for java api
        return "Review Sucessfully Submitted";
    }

    @GetMapping("")
    public String findAllReviews(){
        return "All Reviews";
    }

}
