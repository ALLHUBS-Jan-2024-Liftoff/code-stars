package org.codestars.tenttalk_api.controllers;


import org.codestars.tenttalk_api.dto.CampgroundDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.codestars.tenttalk_api.models.data.UserRepository;
import org.codestars.tenttalk_api.service.CampgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campground")
@CrossOrigin
public class CampgroundController {

    @Autowired
    private CampgroundService campgroundService;

    @PostMapping("/add")
    public ResponseEntity<CampgroundDTO> createdCampground (@RequestBody CampgroundDTO campgroundDTO){
        CampgroundDTO createdCampground = campgroundService.saveCampground(campgroundDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampground);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CampgroundDTO>> getAllCampgrounds() {
        List<CampgroundDTO> campgrounds = campgroundService.getAllCampgrounds();
        return ResponseEntity.ok(campgrounds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampgroundDTO> getCampgroundById(@PathVariable Long id) {
        CampgroundDTO campground = campgroundService.getCampgroundById(id);
        if (campground == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(campground);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CampgroundDTO> updateCampground(@PathVariable Long id, @RequestBody CampgroundDTO campgroundDTO) {
//        CampgroundDTO updatedCampground = campgroundService.updateCampground(id, campgroundDTO);
//        return ResponseEntity.ok(updatedCampground);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampground(@PathVariable Long id) {
        campgroundService.deleteCampground(id);
        return ResponseEntity.noContent().build();
    }


}
