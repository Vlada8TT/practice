package com.example.demo.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Jwt request DTO")
public record JwtRequest(
        @NotNull(message = "Email must be not null.")
        @Schema(description = "User email", example = "user@gmail.com")
        String username,

        @Schema(description = "User password", example = "12345")
        @NotNull(message = "Password must be not null.")
        String password
) {
}
