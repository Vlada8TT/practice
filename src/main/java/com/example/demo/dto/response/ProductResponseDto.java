package com.example.demo.dto.response;

import com.example.demo.persistence.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Product response DTO")
public record ProductResponseDto(
        @Schema(description = "Product id", example = "1")
        Integer id,

        @Schema(description = "Product name", example = "Cola")
        String name,

        @Schema(description = "Product price", example = "3.99")
        BigDecimal price,

        @Schema(description = "Product category")
        Category category,

        @Schema(description = "Product image path")
        String imagePath
) {
}