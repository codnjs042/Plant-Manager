package com.example.plant.domain.Plant.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record PlantCreateRequest(
        @Schema(example="민들레")
        String name,
        @Schema(example="민식")
        String nickname
) {
}
