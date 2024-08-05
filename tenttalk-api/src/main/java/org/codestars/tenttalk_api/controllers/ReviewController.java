package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.dto.ReviewDTO;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
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
    @Autowired
    private ReviewRepository reviewRepository;

//    @PostMapping("/add")
//    public ResponseEntity<ReviewDTO> createdReview (@RequestBody ReviewDTO reviewDTO){
//        ReviewDTO createdReview = reviewService.saveReview(reviewDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
//        List<ReviewDTO> review = reviewService.getAllReviews();
//        return ResponseEntity.ok(review);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
//        ReviewDTO review = reviewService.getReviewById(id);
//        if (review == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        return ResponseEntity.ok(review);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
//        ReviewDTO updatedReview = reviewService.updateReview(id, reviewDTO);
//        return ResponseEntity.ok(updatedReview);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
//        reviewService.deleteReview(id);
//        return ResponseEntity.noContent().build();
//    }


    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO) {
            Review review = reviewService.addReview(reviewDTO);
            return ResponseEntity.ok(review);
        }


    @GetMapping("/getAll")
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(review);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
//        Review review = reviewService.updateReview(id, reviewDTO);
//        return ResponseEntity.ok(review);
//    }

//    @PutMapping("/{id}")
//    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
//        Review review1 = reviewRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Review not found"));
//        review1.setFeedback(review.getFeedback());
//        review1.setRating(review.getRating());
//        review1.setCampground(review.getCampground());
//        review1.setUser(review.getUser());
//        review1.setTags(review.getTags());
//
//        return reviewRepository.save(review1);
//
//    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id, @RequestBody Review review) {
        Review review1 = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        reviewRepository.delete(review1);
        return ResponseEntity.noContent().build();
    }
    
    
    
    
}

