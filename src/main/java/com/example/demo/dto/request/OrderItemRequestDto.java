package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Order item request DTO")
public record OrderItemRequestDto(
        @Schema(description = "Owner(user) id", example = "1")
        @NotNull(message = "{user_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{user_id.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer user_id,

        @Schema(description = "Product id", example = "1")
        @NotNull(message = "{product_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{product_id.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer product_id,

        @Schema(description = "Product quantity", example = "2")
        @NotNull(message = "{quantity.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{quantity.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer quantity
) {
}