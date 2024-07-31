package org.codestars.tenttalk_api.service;

import org.codestars.tenttalk_api.dto.CampgroundDTO;
import org.codestars.tenttalk_api.models.Campground;
import org.codestars.tenttalk_api.models.data.CampgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CampgroundServiceImp implements CampgroundService {
    @Autowired
    private CampgroundRepository campgroundRepository;

    @Override
    public CampgroundDTO saveCampground(CampgroundDTO campgroundDTO) {
        Campground campground = convertToEntity(campgroundDTO);
        Campground savedCampground = campgroundRepository.save(campground);
        return convertToDTO(savedCampground);
    }

    @Override
    public List<CampgroundDTO> getAllCampgrounds() {
        List<Campground> campgrounds = campgroundRepository.findAll();
        List<CampgroundDTO> campgroundDTOs = new ArrayList<>();
        for (Campground campground : campgrounds) {
            campgroundDTOs.add(convertToDTO(campground));
        }
        return campgroundDTOs;
    }

    @Override
    public CampgroundDTO  getCampgroundById(Long id) {
        Campground campground = campgroundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));
        return convertToDTO(campground);

    }

    @Override
    public CampgroundDTO updateCampground(Long id, CampgroundDTO campgroundDTO) {
        Campground campground = campgroundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));
        campground.setName(campgroundDTO.getName());
        campground.setAddress(campgroundDTO.getAddress());
        campground.setWebsite(campgroundDTO.getWebsite());
        campground.setRating(campgroundDTO.getRating());

        Campground updatedCampground = campgroundRepository.save(campground);
      return convertToDTO(updatedCampground);
    }

    @Override
    public void deleteCampground(Long id) {
        Campground campground = campgroundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campground not found"));
        campgroundRepository.delete(campground);
    }

    private Campground convertToEntity(CampgroundDTO dto) {
        Campground campground = new Campground();
        campground.setName(dto.getName());
        campground.setAddress(dto.getAddress());
        campground.setWebsite(dto.getWebsite());
        campground.setRating(dto.getRating());
        //campground.setReviews(dto.getReviews());
        return campground;
    }

    private CampgroundDTO convertToDTO(Campground campground) {
        CampgroundDTO dto = new CampgroundDTO();
        dto.setId(campground.getId());
        dto.setName(campground.getName());
        dto.setAddress(campground.getAddress());
        dto.setWebsite(campground.getWebsite());
        dto.setRating(campground.getRating());
        //dto.setReviews(campground.getReviews());
        return dto;
    }
}