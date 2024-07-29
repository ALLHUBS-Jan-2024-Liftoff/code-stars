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
        ReviewDTO review = convertToEntity(reviewDTO);
        ReviewDTO savedReview = reviewRepository.save(review);
        return convertToDTO(savedReview);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
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
        review.setComments(reviewDTO.getComments());
        review.setAddress(reviewDTO.getAddress());
        review.setWebsite(reviewDTO.getWebsite());
        review.setRating(reviewDTO.getRating());

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
        review.setComments(dto.getComments());
        review.setAddress(dto.getAddress());
        review.setWebsite(dto.getWebsite());
        review.setRating(dto.getRating());
        return review;
    }

    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setComments(review.getComments());
        dto.setWebsite(review.getWebsite());
        dto.setRating(review.getRating());
        return dto;
    }

}