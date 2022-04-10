package com.angler.repository;

import com.angler.domain.FishingDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingDistrictRepository extends JpaRepository<FishingDistrict,Long> {
}
