package com.angler.restController;


import com.angler.domain.Fish;
import com.angler.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FishRestController {

    @Autowired
    private final FishService fishService;

    public FishRestController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/fishes/{id}")
    public Fish getFish(@PathVariable long id){
        Fish fish = fishService.getFish(id);
        return fish;
    }

    @PostMapping("/fishes")
    public Fish createFish(@RequestBody Fish fish){
        Fish savedFish = fishService.saveFish(fish);
        return savedFish;
    }

    @PutMapping("fishes/{id}")
    public Fish updateFish(@PathVariable long id, @RequestBody Fish fish){
        Fish updateFish = fishService.updateFish(id,fish);
        return updateFish;
    }

    @DeleteMapping("fishes/{id}")
    public void deleteFish(@PathVariable Long id){
        fishService.deleteFish(id);
    }

    // TODO check DeleteMapping (foreign key in FishingDistrict)

}
