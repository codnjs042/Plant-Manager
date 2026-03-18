package com.example.plant.domain.user.controller;

import com.example.plant.domain.user.dto.UserCreateRequest;
import com.example.plant.domain.user.dto.UserResponse;
import com.example.plant.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="User API", description ="사용자 API")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary="회원 가입")
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(
            @RequestBody UserCreateRequest dto
    ){
        UserResponse response = userService.signup(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
