package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ingredient response DTO")
public record IngredientResponseDto(
        @Schema(description = "Ingredient id", example = "1")
        Integer id,

        @Schema(description = "Ingredient name", example = "bacon")
        String name
) {
}