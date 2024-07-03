package com.example.demo.controller;

import com.example.demo.dto.auth.JwtRequest;
import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(
        name = "Auth Controller",
        description = "Auth API"
)
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public JwtResponse login(
            @Validated @RequestBody final JwtRequest loginRequest
    ) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserResponseDto register(
            @Validated(OnCreate.class)
            @RequestBody final UserRequestDto userDto
    ) {
        return userService.createUser(userDto);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(
            @RequestBody final String refreshToken
    ) {
        return authService.refresh(refreshToken);
    }

}
