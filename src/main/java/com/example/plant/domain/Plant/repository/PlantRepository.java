package com.example.plant.domain.Plant.repository;

import com.example.plant.domain.Plant.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
