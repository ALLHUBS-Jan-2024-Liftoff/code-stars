package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.dto.FavoriteDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.Favorite;
import org.codestars.tenttalk_api.models.data.FavoriteRepository;
import org.codestars.tenttalk_api.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@CrossOrigin(origins = "http://localhost:5173")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity<Favorite> addFavorite(@RequestBody FavoriteDTO favoriteDTO) {
        Favorite addedFavorite = favoriteService.addToFavorite(favoriteDTO);
        return ResponseEntity.ok(addedFavorite);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getUserFavorites(@PathVariable int userId) {
        List<Favorite> favorites = favoriteService.getFavoritesByUserId(userId);
        return ResponseEntity.ok(favorites);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> removeFavorite(@RequestParam int userId, @RequestParam Long campgroundId) {
        favoriteService.removeFavorite(userId, campgroundId);
        return ResponseEntity.noContent().build();
    }

}
