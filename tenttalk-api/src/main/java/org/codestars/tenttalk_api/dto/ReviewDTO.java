package org.codestars.tenttalk_api.dto;

public class ReviewDTO {

    public ReviewDTO {
        private String comments;
        private Long id;
        private int rating;
    }

    public ReviewDTO(String comments, Long id, int rating){
        this.comments = comments;
        this.id = id;
        this.rating = rating;
    }

    public ReviewDTO(){}

    public getComments(){
        return comments;
    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
