package com.example.plant.domain.Plant.controller;

import com.example.plant.domain.Plant.dto.PlantCreateRequest;
import com.example.plant.domain.Plant.dto.PlantResponse;
import com.example.plant.domain.Plant.service.PlantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Plant API", description ="식물 API")
@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @Operation(summary="식물 등록")
    @PostMapping("/register")
    public ResponseEntity<PlantResponse> register(
            @RequestBody PlantCreateRequest dto
    ){
        PlantResponse response = plantService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
