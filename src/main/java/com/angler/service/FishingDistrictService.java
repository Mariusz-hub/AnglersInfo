package com.angler.service;

import com.angler.domain.FishingDistrict;
import com.angler.repository.FishingDistrictRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishingDistrictService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FishingDistrict.class);
    private final FishingDistrictRepository fishingDistrictRepository;

    public FishingDistrictService(FishingDistrictRepository fishingDistrictRepository) {
        this.fishingDistrictRepository = fishingDistrictRepository;
    }

    public FishingDistrict saveDistrict(FishingDistrict district){
        FishingDistrict fishingDistrict = fishingDistrictRepository.save(district);
        LOGGER.info("Object Fish is created "+fishingDistrict.getName());
        return fishingDistrict;
    }

    public List<FishingDistrict> getFishingDistricts() {
       List<FishingDistrict> fishingDistricts = fishingDistrictRepository.findAll();
       return fishingDistricts;
    }

    public FishingDistrict getFishingDistrict(long id) {
        FishingDistrict fishingDistrict = fishingDistrictRepository.findById(id).orElseThrow
                (() ->new IllegalArgumentException("District not found"));
        return fishingDistrict;
    }

    public FishingDistrict updateOrSaveFishingDistrict(long id, FishingDistrict fishingDistrict) {
        FishingDistrict district = fishingDistrictRepository.findById(id)
                .map(element -> {
                    element.setName(fishingDistrict.getName());
                    return fishingDistrictRepository.save(element);
                }).orElseGet(() -> {
                    fishingDistrict.setId(id);
                    return fishingDistrictRepository.save(fishingDistrict);
                });
        return district;
    }
}
