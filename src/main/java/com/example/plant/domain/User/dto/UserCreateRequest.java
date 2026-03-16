package com.example.plant.domain.User.dto;

import com.example.plant.domain.User.domain.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserCreateRequest(
        @Schema(example="testUser")
        String username,
        @Schema(example="pw1234!!")
        String password,
        @Schema(description="사용자 권한", example="USER", allowableValues = {"USER", "OWNER"})
        UserRole role
) {
}
