package com.angler;

import com.angler.domain.Fish;
import com.angler.service.FishService;
import org.junit.jupiter.api.Test;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class FishServiceTest {

    @Test
    public void getFishes_test(){
        //given
        FishService fishService = mock(FishService.class);
        given(fishService.getFishes()).willReturn(prepareDataFish());

        //when
        List<Fish> fishes =fishService.getFishes();

        //then
        assertThat(fishes,hasSize(2));
    }

    public List<Fish> prepareDataFish(){
        List<Fish> fishes = new ArrayList<>();
        Fish fish = new Fish("Okon",24, LocalDate.now(),LocalDate.now().plusMonths(4));
        Fish fish1 = new Fish("Plotka",34, LocalDate.now(),LocalDate.now().plusMonths(4));
        fishes.add(fish);
        fishes.add(fish1);
        return fishes;
    }
}
