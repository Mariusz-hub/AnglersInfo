package com.angler.service;

import com.angler.domain.FishingDistrict;
import com.angler.repository.FishingDistrictRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FishDistrictService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FishingDistrict.class);
    private final FishingDistrictRepository fishingDistrictRepository;

    public FishDistrictService(FishingDistrictRepository fishingDistrictRepository) {
        this.fishingDistrictRepository = fishingDistrictRepository;
    }

    public FishingDistrict saveDistrict(FishingDistrict district){
        FishingDistrict fishingDistrict = fishingDistrictRepository.save(district);
        LOGGER.info("Object Fish is created "+fishingDistrict.getName());
        return fishingDistrict;
    }
}
