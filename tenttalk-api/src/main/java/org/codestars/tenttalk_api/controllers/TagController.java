package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.models.Tag;
import org.codestars.tenttalk_api.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tag")
@CrossOrigin(origins = "http://localhost:5173")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/add")
    public String addTag(@RequestBody Tag tag) {
        tagService.saveTag(tag);
        return "New Tag Created";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        if (tags == null || tags.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
}

