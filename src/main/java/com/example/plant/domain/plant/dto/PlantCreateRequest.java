package com.example.plant.domain.plant.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record PlantCreateRequest(
        @Schema(example="민들레")
        String name,
        @Schema(example="민식")
        String nickname,
        @Schema(example="2026-01-01")
        LocalDate lastWateredDay
) {
    public PlantCreateRequest{
        if(lastWateredDay==null)
            lastWateredDay=LocalDate.now();
    }
}
