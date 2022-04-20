package com.angler.restController;


import com.angler.domain.Fish;
import com.angler.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class FishRestController {

    @Autowired
    private final FishService fishService;

    public FishRestController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/fishes")
    public CollectionModel<EntityModel<Fish>> getFishes(){
        List<EntityModel<Fish>> fishes = fishService.getFishes().stream()
                .map(fish -> EntityModel.of(fish,linkTo(methodOn(FishRestController.class).getFish(fish.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return CollectionModel.of(fishes,linkTo(methodOn(FishRestController.class).getFishes()).withSelfRel());
    }

    @GetMapping("/fishes/{id}")
    public EntityModel<Fish> getFish(@PathVariable long id){
        return EntityModel.of(fishService.getFish(id),
                linkTo(methodOn(FishRestController.class).getFish(id)).withSelfRel(),
                linkTo(methodOn(FishRestController.class).getFishes()).withRel("fishes")

        );

    }

    @PostMapping("/fishes")
    public ResponseEntity<EntityModel<Fish>> createFish(@RequestBody Fish fish){
        Fish savedFish = fishService.saveFish(fish);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                EntityModel.of(savedFish,
                linkTo(methodOn(FishRestController.class).createFish(fish)).withSelfRel(),
                linkTo(methodOn(FishRestController.class).getFishes()).withRel("fishes")));
    }

    @PutMapping("fishes/{id}")
    public ResponseEntity<Fish> updateFish(@PathVariable long id, @RequestBody Fish fish){
        Fish updateFish = fishService.updateFish(id,fish);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("fishes/{id}")
    public void  deleteFish(@PathVariable Long id){
        fishService.deleteFish(id);
    }

    // TODO check DeleteMapping (foreign key)

}
