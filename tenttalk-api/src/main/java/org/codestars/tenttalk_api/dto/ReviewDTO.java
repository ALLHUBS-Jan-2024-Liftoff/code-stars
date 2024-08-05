package org.codestars.tenttalk_api.dto;

public class ReviewDTO{
        private String feedback;
        private int rating;
        private Long campgroundId;

        public ReviewDTO() {

        }

    public ReviewDTO(String feedback, int rating, Long campgroundId) {
        this.feedback = feedback;
        this.rating = rating;
        this.campgroundId = campgroundId;
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
}