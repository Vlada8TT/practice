package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order item response DTO")
public record OrderItemResponseDto(
        @Schema(description = "Order item id", example = "1")
        Integer id,

        @Schema(description = "Owner(user) id", example = "1")
        Integer user_id,

        @Schema(description = "Product id", example = "1")
        Integer product_id,

        @Schema(description = "Product quantity", example = "2")
        Integer quantity
) {
}