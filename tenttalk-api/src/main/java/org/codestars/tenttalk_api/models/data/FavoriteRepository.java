package org.codestars.tenttalk_api.models.data;

import org.codestars.tenttalk_api.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

List<Favorite> findByUserId(int userId);

}
