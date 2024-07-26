package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public String addReview(@RequestBody Review review){
        reviewService.saveReview(review);
        return "New Review Added";
    }


}
