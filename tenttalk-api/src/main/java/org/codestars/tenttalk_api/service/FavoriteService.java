package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface FavoriteService {

    @Autowired
    CampgroundRepository campgroundRepository;
    @Autowired
    UserRepository userRepository;



}
