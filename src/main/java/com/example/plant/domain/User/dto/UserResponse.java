package com.example.plant.domain.User.dto;

import com.example.plant.domain.User.domain.User;
import com.example.plant.domain.User.domain.UserRole;
import com.example.plant.domain.User.domain.UserStatus;

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
