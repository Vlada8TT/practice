package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Order response DTO")
public record OrderResponseDto(
        @Schema(description = "Order id", example = "1")
        Integer id,

        @Schema(description = "Owner(user) id", example = "1")
        Integer user_id,

        @Schema(description = "Order creation date", example = "11/11/2023")
        LocalDateTime time,

        @Schema(description = "Order status", example = "NEW")
        String status
) {
}