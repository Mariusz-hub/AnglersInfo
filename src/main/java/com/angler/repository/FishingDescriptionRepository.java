package com.angler.repository;

import com.angler.domain.FishDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingDescriptionRepository extends JpaRepository<FishDescription,Long> {
}
