package org.codestars.tenttalk_api.controllers;

import org.codestars.tenttalk_api.models.Tag;
import org.codestars.tenttalk_api.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/add")
    public String addTag(@RequestBody Tag tag){
        tagService.saveTag(tag);
        return "New Tag Created";
    }

}
