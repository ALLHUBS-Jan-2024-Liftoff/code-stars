package org.codestars.tenttalk_api.controllers;


import org.codestars.tenttalk_api.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String signedIn() {
        return "No Bears Allowed";
    }

}
