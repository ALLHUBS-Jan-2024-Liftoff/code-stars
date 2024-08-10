package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.models.Tag;
import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag findByName(String name);
    List<Tag> getAllTags();
}



