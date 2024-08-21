package org.codestars.tenttalk_api.dto;

import java.util.List;

public class ReviewDTO {
    private String feedback;
    private int rating;
    private Long campgroundId;
    private Long userId;
    private List<String> tags;

    public ReviewDTO() {}

    public ReviewDTO(String feedback, int rating, Long campgroundId, Long userId, List<String> tags) {
        this.feedback = feedback;
        this.rating = rating;
        this.campgroundId = campgroundId;
        this.userId = userId;
        this.tags = tags;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(Long campgroundId) {
        this.campgroundId = campgroundId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
