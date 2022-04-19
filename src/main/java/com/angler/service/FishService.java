package com.angler.service;

import com.angler.domain.Fish;
import com.angler.repository.FishRepository;
import com.angler.repository.FishingDistrictRepository;
import com.angler.utils.FishMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class FishService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FishService.class);
    private final FishRepository fishRepository;
    private final FishingDistrictRepository fishingDistrictRepository;
    private final FishMapper fishMapper;

    @Autowired
    public FishService(FishRepository fishRepository, FishingDistrictRepository fishingDistrictRepository, FishMapper fishMapper) {
        this.fishRepository = fishRepository;
        this.fishingDistrictRepository = fishingDistrictRepository;
        this.fishMapper = fishMapper;
    }

    public Fish saveFish(Fish fish){
        Fish fishToSave = fishRepository.save(fish);
        LOGGER.info("Object Fish is created",fishToSave);
        return fishToSave;
    }


    public Fish getFish(long id) {
        Fish fish = fishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fish not found"));
        return fish;
    }

    public Fish updateFish(long id, Fish fish) {
        return fishRepository.findById(id)
                .map(element -> {
                    element.setName(fish.getName());
                    element.setProtectionSize(fish.getProtectionSize());
                    element.setPeriodOfProtectionFrom(fish.getPeriodOfProtectionFrom());
                    element.setPeriodOfProtectionTo(fish.getPeriodOfProtectionTo());
                    return fishRepository.save(element);
                }).orElseGet(()->{
                    fish.setId(id);
                    return  fishRepository.save(fish);
                });


    }

    public void deleteFish(Long id) {
        Fish deleteFish = fishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fish not found"));
        fishRepository.delete(deleteFish);
    }
}
