package org.codestars.tenttalk_api.dto;

import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.User;

import java.util.List;

public class FavoriteDTO {

    private int userId;
    private Long CampId;


    public FavoriteDTO(int userId, Long campId) {
        this.userId = userId;
        CampId = campId;
    }

    public FavoriteDTO(){}

    public Long getCampId() {
        return CampId;
    }

    public void setCampId(Long campId) {
        CampId = campId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}