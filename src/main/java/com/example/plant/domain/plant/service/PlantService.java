package com.example.plant.domain.plant.service;

import com.example.plant.domain.plant.domain.Plant;
import com.example.plant.domain.plant.domain.PlantStatus;
import com.example.plant.domain.plant.dto.PlantCreateRequest;
import com.example.plant.domain.plant.dto.PlantResponse;
import com.example.plant.domain.plant.repository.PlantRepository;
import com.example.plant.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlantService {
    private final PlantRepository plantRepository;

    @Transactional
    public PlantResponse register(User user, PlantCreateRequest dto) {
        Plant plant = Plant.builder()
                .name(dto.name())
                .nickname(dto.nickname())
                .user(user)
                .lastWateredDay(dto.lastWateredDay())
                .status(PlantStatus.ACTIVE)
                .build();

        plantRepository.save(plant);

        return PlantResponse.from(plant);
    }

    public List<PlantResponse> getList(Long userId) {
        List<Plant> plants = plantRepository.getList(userId, PlantStatus.ACTIVE);
        return plants.stream()
                .map(PlantResponse::from)
                .toList();
    }

    @Transactional
    public void delete(Long userId, Long plantId){
        Plant plant = plantRepository.findById(plantId)
                .orElseThrow(() -> new IllegalArgumentException("해당 식물이 없습니다."));

        plant.updateStatus(PlantStatus.DELETED);
    }
}
