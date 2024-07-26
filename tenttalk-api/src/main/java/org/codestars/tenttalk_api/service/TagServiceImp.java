package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Tag;
import org.codestars.tenttalk_api.models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagServiceImp implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

}