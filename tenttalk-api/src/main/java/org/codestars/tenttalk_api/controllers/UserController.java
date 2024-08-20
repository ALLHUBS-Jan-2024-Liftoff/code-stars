package org.codestars.tenttalk_api.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.codestars.tenttalk_api.dto.RegisterFormDTO;
import org.codestars.tenttalk_api.dto.LoginFormDTO;
import org.codestars.tenttalk_api.models.User;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.codestars.tenttalk_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    public static final String userSessionKey = "user";

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterFormDTO registerFormDTO, HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        User existingUser = userRepository.findByEmail(registerFormDTO.getUsername());
        if (existingUser != null) {
            response.put("message", "User already exists.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        User newUser = new User(registerFormDTO.getEmail(), registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);
        response.put("message", "User registered successfully.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginFormDTO loginFormDTO, HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findByEmail(loginFormDTO.getEmail());

        if (user == null || !user.isMatchingPassword(loginFormDTO.getPassword())) {
            response.put("message", "Invalid username or password.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        setUserInSession(request.getSession(), user);
        String userId = String.valueOf(user.getId());
        response.put("userId", userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        Map<String, String> response = new HashMap<>();
        response.put("message", "User logged out successfully.");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {return (List<User>) userRepository.findAll();}

    @GetMapping("/account")
    public ResponseEntity<User> getUserById(HttpSession session) {
        User currentUser = getUserFromSession(session);
        return ResponseEntity.ok(currentUser);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User user1 = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());

        return userRepository.save(user1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id, @RequestBody User user) {
        User user1 = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user1);
        return ResponseEntity.noContent().build();
    }
}

