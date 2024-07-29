package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Review;

import java.util.List;

public interface ReviewService {

    public Review saveReview(Review review);

    public List<Review> getAllReviews();
}
