package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.models.User;
import org.codestars.tenttalk_api.models.data.ReviewRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.codestars.tenttalk_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return user;
        } else {
            return null;  // Failed login
        }
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {return userRepository.findAll();}
}

