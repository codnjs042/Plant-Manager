package com.example.plant.domain.plant.domain;

import com.example.plant.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @Enumerated(EnumType.STRING)
    private PlantWinterMinTemp winterMinTemp;

    @Enumerated(EnumType.STRING)
    private PlantWaterCycle spring;

    @Enumerated(EnumType.STRING)
    private PlantWaterCycle summer;

    @Enumerated(EnumType.STRING)
    private PlantWaterCycle fall;

    @Enumerated(EnumType.STRING)
    private PlantWaterCycle winter;

    @Column
    private LocalDate lastWateredDay;

    @Enumerated(EnumType.STRING)
    private PlantStatus status;

    @Builder
    public Plant(String name, String nickname, User user, LocalDate lastWateredDay, PlantStatus status){
        this.name=name;
        this.nickname=nickname;
        this.user=user;
        this.lastWateredDay=lastWateredDay;
        this.status=status;
    }

    public void updateStatus(PlantStatus status){
        this.status = status;
    }
}
