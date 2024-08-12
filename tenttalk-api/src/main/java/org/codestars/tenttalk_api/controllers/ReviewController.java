package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.dto.ReviewDTO;
import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.addReview(reviewDTO);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> getAllReviews() {
        try {
            List<Review> reviews = reviewService.findAll();
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.updateReview(id, reviewDTO);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }
}



