package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CampgroundService {

    @Autowired
    private CampgroundRepository campgroundRepository;
    public Campground findMostPopularCampground() {
        List<Campground> campgrounds = campgroundRepository.findAll();


        return campgrounds.stream()
                .max(Comparator.comparingDouble(Campground::getRating))
                .orElse(null);
    }
    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public Campground addWithReviews(Campground campground) {
        List<Review> reviews = campground.getReviews();
        campground.setReviews(new ArrayList<>());

        Campground savedCampground = campgroundRepository.save(campground);

        for(Review review: reviews){
            review.setCampground(savedCampground);
            reviewRepository.save(review);
            savedCampground.getReviews().add(review);
        }
        return campgroundRepository.save(savedCampground);
    }


}
