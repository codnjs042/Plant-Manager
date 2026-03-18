package com.example.plant.domain.user.dto;

import com.example.plant.domain.user.domain.User;
import com.example.plant.domain.user.domain.UserRole;
import com.example.plant.domain.user.domain.UserStatus;

public record UserResponse(
        Long id,
        String username,
        UserRole role,
        UserStatus status
) {
    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                user.getStatus()
        );
    }
}
