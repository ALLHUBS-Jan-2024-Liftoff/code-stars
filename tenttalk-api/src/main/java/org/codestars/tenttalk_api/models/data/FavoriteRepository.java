package org.codestars.tenttalk_api.models.data;

import org.codestars.tenttalk_api.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {



}
