package com.example.demo.dto.auth;

public record JwtResponse(
        Integer id,

        String email,

        String accessToken,

        String refreshToken
) {
}
