package org.codestars.tenttalk_api.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @PostMapping("review/create")
    public String createReview() {

        return "Review Sucessfully Submitted";
    }

    @GetMapping("review/findAll")
    public String findAllReviews(){
        return "All Reviews";
    }

}
