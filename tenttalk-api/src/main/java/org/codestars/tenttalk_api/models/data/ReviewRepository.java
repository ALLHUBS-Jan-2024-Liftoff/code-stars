package org.codestars.tenttalk_api.models.data;

import org.codestars.tenttalk_api.models.Review;
import org.codestars.tenttalk_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser(User user);


}
