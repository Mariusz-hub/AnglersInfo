package com.angler.service;

import com.angler.domain.Fish;
import com.angler.repository.FishRepository;
import com.angler.utils.FishMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class FishService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FishService.class);
    private final FishRepository fishRepository;
    private final FishMapper fishMapper;

    @Autowired
    public FishService(FishRepository fishRepository, FishMapper fishMapper) {
        this.fishRepository = fishRepository;
        this.fishMapper = fishMapper;
    }

    public Fish saveFish(Fish fish){
        Fish fishToSave = fishRepository.save(fish);
        LOGGER.info("Object Fish is created",fishToSave);
        return fishToSave;
    }

    @EventListener(ApplicationReadyEvent.class)// wywolywana w momencie uruchumienia apki
    public void fillDb(){

    }


}
