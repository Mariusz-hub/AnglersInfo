package com.angler;

import com.angler.domain.Fish;
import com.angler.domain.FishDescription;
import com.angler.domain.FishingDistrict;
import com.angler.repository.FishRepository;
import com.angler.repository.FishingDescriptionRepository;
import com.angler.repository.FishingDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AnglersInfoApplication implements CommandLineRunner {

	@Autowired
	private final FishRepository fishRepository;
	@Autowired
	private  final FishingDistrictRepository fishingDistrictRepository;
	@Autowired
	private final FishingDescriptionRepository fishingDescriptionRepository;

	public AnglersInfoApplication(FishRepository fishRepository, FishingDistrictRepository fishingDistrictRepository, FishingDescriptionRepository fishingDescriptionRepository) {
		this.fishRepository = fishRepository;
		this.fishingDistrictRepository = fishingDistrictRepository;
		this.fishingDescriptionRepository = fishingDescriptionRepository;
	}

	public static void main(String[] args)  {
		SpringApplication.run(AnglersInfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		FishingDistrict mazowsze = new FishingDistrict("Okręg Mazowiecki");
		FishingDistrict skierniewice = new FishingDistrict("Okręg Skierniewicki");

		Fish fish = new Fish("Szczupak",55, LocalDate.now(),LocalDate.now().plusMonths(3l));
		Fish fish1 = new Fish("Szczupak",50, LocalDate.now(),LocalDate.now().plusMonths(3l));

		FishDescription fishDescription = new FishDescription("Szczupak Król Wód",fish);
		FishDescription fishDescription1 = new FishDescription("Szczupak Król Wód",fish1);


		fishRepository.save(fish);
		fishRepository.save(fish1);
		fishingDescriptionRepository.save(fishDescription);
		fishingDescriptionRepository.save(fishDescription1);
		mazowsze.addFish(fish);
		skierniewice.addFish(fish1);
		fishingDistrictRepository.saveAll(List.of(mazowsze,skierniewice));

	}
}
