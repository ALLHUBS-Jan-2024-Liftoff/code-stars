package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.ReviewDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.models.Tag;
import org.codestars.tenttalk_api.models.User;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CampgroundRepository campgroundRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagService tagService;

    public Review addReview(ReviewDTO reviewDTO) {
        Campground campground = campgroundRepository.findById(reviewDTO.getCampgroundId())
                .orElseThrow(() -> new RuntimeException("Campground not found"));

        User user = userRepository.findById(reviewDTO.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Tag> tags = saveTags(reviewDTO.getTags());

        Review review = new Review();
        review.setFeedback(reviewDTO.getFeedback());
        review.setRating(reviewDTO.getRating());
        review.setCampground(campground);
        review.setUser(user);
        review.setTags(tags);

        return reviewRepository.save(review);
    }

    private List<Tag> saveTags(List<String> tagNames) {
        List<Tag> tags = new ArrayList<>();
        for (String tagName : tagNames) {
            Tag tag = tagService.findByName(tagName);
            if (tag == null) {
                tag = new Tag(tagName);
                tagService.saveTag(tag);
            }
            tags.add(tag);
        }
        return tags;
    }

    public Review updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setFeedback(reviewDTO.getFeedback());
        review.setRating(reviewDTO.getRating());

        if (reviewDTO.getCampgroundId() != null) {
            Campground campground = campgroundRepository.findById(reviewDTO.getCampgroundId())
                    .orElseThrow(() -> new RuntimeException("Campground not found"));
            review.setCampground(campground);
        }

        List<Tag> tags = saveTags(reviewDTO.getTags());
        review.setTags(tags);

        return reviewRepository.save(review);
    }

    public Campground updateAverageRating (Campground campground, Review newReview) {
        // get all ratings for campground
        List<Review> reviews = campground.getReviews();

        // add new review to reviews list
        reviews.add(newReview);

        // calculate average of current ratings
        Double ratingSum = 0.0;
        for (Review review : reviews) {
            ratingSum = ratingSum + review.getRating();
        }
        Double ratingAverage = ratingSum / reviews.toArray().length;

        // update campground.rating with new average
        campground.setRating(ratingAverage);

        return campgroundRepository.save(campground);
    }

    public String deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        Campground campground = review.getCampground();
        if (campground != null) {
            campground.getReviews().remove(review);
            campgroundRepository.save(campground);
        }
        User user = review.getUser();
        if (user != null) {
            user.getReviews().remove(review);
            userRepository.save(user);
        }
        reviewRepository.delete(review);
        return "review deleted";
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }
}


