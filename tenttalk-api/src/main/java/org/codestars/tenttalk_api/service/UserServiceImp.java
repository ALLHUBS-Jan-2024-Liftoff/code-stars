package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.User;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

//    @Override
//    public List<Review> getAllReviews() {
//        return reviewRepository.findAll();
//    }

}