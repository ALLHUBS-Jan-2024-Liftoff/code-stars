package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.FavoriteDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Favorite;
import org.codestars.tenttalk_api.models.User;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.FavoriteRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    CampgroundRepository campgroundRepository;
    @Autowired
    UserRepository userRepository;

    public Favorite addToFavorite(FavoriteDTO favoriteDTO){
        User user = userRepository.findById(favoriteDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Campground campground = campgroundRepository.findById(favoriteDTO.getCampId())
                .orElseThrow(() -> new RuntimeException("Campground not found"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setCampground(campground);

        return favoriteRepository.save(favorite);
    }

    public List<Favorite> getFavoritesByUserId(int userId) {
        return favoriteRepository.findByUserId(userId);
    }

//    public void removeFavorite(int userId, Long campgroundId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Campground campground = campgroundRepository.findById(campgroundId);
//
//        favoriteRepository.deleteByUserIdAndCampgroundId(userId, campgroundId);
//
//    }
    public void removeByFavoriteId(Long id) {
        Favorite favorite = favoriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorite not found"));

        User user = favorite.getUser();
        if(user != null) {
            user.removeFromFavorite(favorite);
        }
        favoriteRepository.deleteById(id);
    }

}






