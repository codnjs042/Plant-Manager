package com.example.plant.domain.User.service;

import com.example.plant.domain.User.domain.User;
import com.example.plant.domain.User.domain.UserRole;
import com.example.plant.domain.User.domain.UserStatus;
import com.example.plant.domain.User.dto.UserCreateRequest;
import com.example.plant.domain.User.dto.UserResponse;
import com.example.plant.domain.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse signup(UserCreateRequest dto){
        Optional<User> existing = userRepository.findByUsername(dto.username());
        if(existing.isPresent())
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");

        String encode = passwordEncoder.encode(dto.password());

        User user = User.builder()
                .username(dto.username())
                .password(encode)
                .role(UserRole.USER)
                .status(UserStatus.ACTIVE)
                .build();

        userRepository.save(user);

        return UserResponse.from(user);
    }
}
