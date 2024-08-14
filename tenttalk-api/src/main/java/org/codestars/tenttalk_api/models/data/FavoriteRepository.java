package org.codestars.tenttalk_api.models.data;

import org.codestars.tenttalk_api.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

List<Favorite> findByUserId(int userId);

//@Query(value = "DELETE FROM Favorites f WHERE f.userid = :userId AND f.campground.id = :campgroundId", nativeQuery = true)
//void deleteByUserIdAndCampgroundId(@RequestParam("userId")int userId, @RequestParam("campgroundId") Long campgroundId);

}
