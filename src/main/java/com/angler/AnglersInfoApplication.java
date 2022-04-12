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
		FishDescription fishDescription = new FishDescription("Szczupak Król Wód");
		FishingDistrict mazowsze = new FishingDistrict("Okręg Mazowiecki");
		FishingDistrict skierniewice = new FishingDistrict("Okręg Skierniewicki");

		Fish fish = new Fish("Szczupak",55, LocalDate.now(),LocalDate.now().plusMonths(3l),fishDescription);
		Fish fish1 = new Fish("Szczupak",50, LocalDate.now(),LocalDate.now().plusMonths(3l),fishDescription);

		fish.getFishingDistricts().add(mazowsze);
		fish1.getFishingDistricts().add(skierniewice);
		mazowsze.getFishSet().add(fish);
		skierniewice.getFishSet().add(fish);
		fishingDescriptionRepository.save(fishDescription);
		fishingDistrictRepository.save(mazowsze);
		fishingDistrictRepository.save(skierniewice);
		fishRepository.save(fish);
		fishRepository.save(fish1);
	}
}
