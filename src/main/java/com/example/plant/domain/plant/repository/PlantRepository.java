package com.example.plant.domain.plant.repository;

import com.example.plant.domain.plant.domain.Plant;
import com.example.plant.domain.plant.domain.PlantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    @Query("""
            select p from Plant p
            where p.user.id = :userId
            and p.status = status
            """)
    List<Plant> getList(
            @Param("userId") Long userId,
            @Param("status") PlantStatus status);
}
