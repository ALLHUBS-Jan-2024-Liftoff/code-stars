package org.codestars.tenttalk_api.models.data;

import org.codestars.tenttalk_api.models.Campground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampgroundRepository extends JpaRepository<Campground, Integer> {



}
