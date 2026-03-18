package com.example.plant.domain.plant.dto;

import com.example.plant.domain.plant.domain.Plant;
import com.example.plant.domain.plant.domain.PlantStatus;

public record PlantResponse(
        Long id,
        String name,
        String nickname,
        PlantStatus status
) {
    public static PlantResponse from(Plant plant) {
        return new PlantResponse(
                plant.getId(),
                plant.getName(),
                plant.getNickname(),
                plant.getStatus()
        );
    }
}