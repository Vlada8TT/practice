package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Timestamp;

@Schema(description = "Order response DTO")
public record OrderResponseDto(
        @Schema(description = "Order id", example = "1")
        Integer id,

        @Schema(description = "Order creation date", example = "11/11/2023")
        Timestamp orderDate,

        @Schema(description = "Order status", example = "NEW")
        String status
) {
}