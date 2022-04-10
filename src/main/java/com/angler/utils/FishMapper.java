package com.angler.utils;

import com.angler.domain.Fish;
import com.angler.domain.FishDto;
import org.springframework.stereotype.Component;

@Component
public class FishMapper implements MapperDto<FishDto, Fish> {
    @Override
    public FishDto from(Fish from) {
        FishDto fishDto = new FishDto(from.getName(), from.getProtectionSize(),
                from.getPeriodOfProtectionFrom(),from.getPeriodOfProtectionTo());
        return fishDto;
    }
}
