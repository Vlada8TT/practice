package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record OrderItemRequestDto(
        @Schema(description = "Product id", example = "1")
        @NotNull(message = "{product_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer productId,

        @Schema(description = "Product quantity", example = "2")
        @NotNull(message = "{quantity.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer quantity
) {
}