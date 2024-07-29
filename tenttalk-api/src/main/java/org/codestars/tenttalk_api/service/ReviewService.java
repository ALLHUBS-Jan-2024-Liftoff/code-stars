package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    ReviewDTO saveReview(ReviewDTO reviewDTO);
    List<ReviewDTO>getAllReviews();
    ReviewDTO getReviewById(Long id);
    ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
    void deleteReview(Long id);

}
