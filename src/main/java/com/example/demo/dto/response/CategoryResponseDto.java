package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Category response DTO")
public record CategoryResponseDto(
        @Schema(description = "Category id", example = "1")
        Integer id,

        @Schema(description = "Category name", example = "drink")
        String name
) {
}