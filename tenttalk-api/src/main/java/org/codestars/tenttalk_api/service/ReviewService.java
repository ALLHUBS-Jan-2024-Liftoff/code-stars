package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.ReviewDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CampgroundRepository campgroundRepository;


    public Review addReview(ReviewDTO reviewDTO) {

        Campground campground = campgroundRepository.findById(reviewDTO.getCampgroundId())
                .orElseThrow(() -> new RuntimeException("Campground not found"));

        Review review = new Review();
        review.setFeedback(reviewDTO.getFeedback());
        review.setRating(reviewDTO.getRating());
        review.setCampground(campground);
        return reviewRepository.save(review);
    }


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


    public void deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));

        Campground campground = review.getCampground();
        if (campground != null) {
            campground.getReviews().remove(review);
            campgroundRepository.save(campground);
        }
        reviewRepository.delete(review);
    }
}
