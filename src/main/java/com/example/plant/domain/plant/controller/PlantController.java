package com.example.plant.domain.plant.controller;

import com.example.plant.domain.plant.dto.PlantCreateRequest;
import com.example.plant.domain.plant.dto.PlantResponse;
import com.example.plant.domain.plant.service.PlantService;
import com.example.plant.global.security.CustomUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Plant API", description ="식물 API")
@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @Operation(summary="식물 등록")
    @PostMapping("/register")
    public ResponseEntity<PlantResponse> register(
            @RequestBody PlantCreateRequest dto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        PlantResponse response = plantService.register(userDetails.getUser(), dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary="식물 도감")
    @GetMapping
    public ResponseEntity<List<PlantResponse>> getList(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        List<PlantResponse> response = plantService.getList(userDetails.getId());
        return ResponseEntity.ok(response);
    }

    @Operation(summary="식물 삭제")
    @DeleteMapping("/{plantId}")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @PathVariable Long plantId
    ){
        plantService.delete(userDetails.getId(), plantId);
        return ResponseEntity.noContent().build();
    }
}
