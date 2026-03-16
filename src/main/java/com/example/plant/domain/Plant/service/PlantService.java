package com.example.plant.domain.Plant.service;

import com.example.plant.domain.Plant.domain.Plant;
import com.example.plant.domain.Plant.domain.PlantStatus;
import com.example.plant.domain.Plant.dto.PlantCreateRequest;
import com.example.plant.domain.Plant.dto.PlantResponse;
import com.example.plant.domain.Plant.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlantService {
    private final PlantRepository plantRepository;

    @Transactional
    public PlantResponse register(PlantCreateRequest dto){
        Plant plant = Plant.builder()
                .name(dto.name())
                .nickname(dto.nickname())
                .status(PlantStatus.ACTIVE)
                .build();

        plantRepository.save(plant);

        return PlantResponse.from(plant);
    }
}
