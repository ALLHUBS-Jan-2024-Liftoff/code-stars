package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.ReviewDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ReviewService1 {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CampgroundRepository campgroundRepository;

    @Transactional
    public Review addReview(ReviewDTO reviewDTO) {

        Campground campground = campgroundRepository.findById(reviewDTO.getCampgroundId())
                .orElseThrow(() -> new RuntimeException("Campground not found"));

        Review review = new Review();
        review.setFeedback(reviewDTO.getFeedback());
        review.setRating(reviewDTO.getRating());
        review.setCampground(campground);
        return reviewRepository.save(review);
    }

    @Transactional
    public Review updateReview (Long id, ReviewDTO reviewDTO){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setFeedback((reviewDTO.getFeedback()));
        review.setRating(reviewDTO.getRating());

        if (reviewDTO.getCampgroundId() != null) {
            Campground campground = campgroundRepository.findById(reviewDTO.getCampgroundId())
                    .orElseThrow(() -> new RuntimeException("Campground not found"));
            review.setCampground(campground);
        }
        return reviewRepository.save(review);
    }

}