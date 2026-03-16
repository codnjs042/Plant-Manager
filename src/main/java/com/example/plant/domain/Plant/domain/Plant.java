package com.example.plant.domain.Plant.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String nickname;

    @Enumerated(EnumType.STRING)
    private PlantGrowthSpeed speed;

    @Enumerated(EnumType.STRING)
    private PlantWinterMinTemp winterMinTemp;

    @Enumerated(EnumType.STRING)
    private PlantHumidity humidity;

    @Column
    private int waterCycle;

    @Enumerated(EnumType.STRING)
    private PlantStatus status;

    @Builder
    public Plant(String name, String nickname, PlantStatus status){
        this.name=name;
        this.nickname=nickname;
        this.status=status;
    }
}
