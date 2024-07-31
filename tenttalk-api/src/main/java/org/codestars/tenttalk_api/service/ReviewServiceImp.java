package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.ReviewDTO;
import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDTO saveReview(ReviewDTO reviewDTO) {
        Review review = convertToEntity(reviewDTO);
        Review savedReview = reviewRepository.save(review);
        return convertToDTO(savedReview);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = (List<Review>) reviewRepository.findAll();
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review review : reviews) {
            reviewDTOs.add(convertToDTO(review));
        }
        return reviewDTOs;
    }

    @Override
    public ReviewDTO  getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));
        return convertToDTO(review);

    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));
        review.setFeedback(reviewDTO.getFeedback());
        review.setRating(reviewDTO.getRating());
        review.setUser(reviewDTO.getUser());
        review.setTags(reviewDTO.getTag());

        Review updatedReview = reviewRepository.save(review);
        return convertToDTO(updatedReview);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));
        reviewRepository.delete(review);
    }

    private Review convertToEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setFeedback(dto.getFeedback());
        review.setRating(dto.getRating());
        review.setUser(dto.getUser());
        review.setTags(dto.getTag());
        return review;
    }

    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setFeedback(review.getFeedback());
        dto.setRating(review.getRating());
        dto.setUser(review.getUser());
        dto.setTag(review.getTags());
        return dto;
    }

}