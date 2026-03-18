package com.example.plant.domain.plant.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PlantWinterMinTemp {
    TEMP_0_BELOW("057001", 0),
    TEMP_5("057002", 5),
    TEMP_7("057003", 7),
    TEMP_10("057004", 10),
    TEMP_13_ABOVE("057005", 13);

    private final String code;
    private final int minTemp;
}
