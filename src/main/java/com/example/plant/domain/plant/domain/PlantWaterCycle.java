package com.example.plant.domain.plant.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PlantWaterCycle {
    WATER_LOGGED("053001", "항상 흙을 축축하게 유지함(물에 잠김)"),
    MOIST("053002", "흙을 촉촉하게 유지함(물에 잠기지 않도록 주의)"),
    SURFACE_DRY("053003", "토양 표면이 말랐을때 충분히 관수함"),
    MOSTLY_DRY("053004", "화분 흙 대부분 말랐을 때 충분히 관수함");

    private final String code;
    private final String desc;
}