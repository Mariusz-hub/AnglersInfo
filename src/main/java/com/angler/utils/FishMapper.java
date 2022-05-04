package com.angler.utils;

import com.angler.domain.Fish;
import com.angler.domain.FishDto;
import org.springframework.stereotype.Component;

@Component
public class FishMapper implements MapperDto<FishDto, Fish> {
    @Override
    public FishDto map(Fish fish) {
        FishDto fishDto = new FishDto(fish.getName(), fish.getProtectionSize(),
                fish.getPeriodOfProtectionFrom(),fish.getPeriodOfProtectionTo());
        return fishDto;
    }
}
