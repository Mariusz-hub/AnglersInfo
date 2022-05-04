package com.angler.restController;

import com.angler.domain.Fish;
import com.angler.domain.FishingDistrict;
import com.angler.service.FishingDistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FishingDistrictRestController {

   private final FishingDistrictService fishingDistrictService;

    public FishingDistrictRestController(FishingDistrictService fishingDistrictService) {
        this.fishingDistrictService = fishingDistrictService;
    }

    @GetMapping("/fishingDistricts")
    public List<FishingDistrict> getFishingDistricts(){
       List<FishingDistrict> fishingDistrict = fishingDistrictService.getFishingDistricts();
       return fishingDistrict;
    }

    @GetMapping("/fishingDistricts/{id}")
    public FishingDistrict getFishingDistrict (@PathVariable long id){
        FishingDistrict fishingDistrict = fishingDistrictService.getFishingDistrict(id);
        return fishingDistrict;
    }

    @PostMapping("/fishingDistricts")
    public FishingDistrict createFishingDistrict(@RequestBody FishingDistrict fishingDistrict){
        FishingDistrict saveDistrict = fishingDistrictService.saveDistrict(fishingDistrict);
        return saveDistrict;
    }

    @PutMapping("/fishingDistrict/{id}")
    public FishingDistrict updateOrSaveFishingDistrict(long id, @RequestBody FishingDistrict fishingDistrict){
      FishingDistrict district = fishingDistrictService.updateOrSaveFishingDistrict(id,fishingDistrict);
      return district;
    }


}
