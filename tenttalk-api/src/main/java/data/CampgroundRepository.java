package data;

import models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampgroundRepository extends CrudRepository<User, Integer> {



}
