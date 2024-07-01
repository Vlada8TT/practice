package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Schema(description = "Order request DTO")
public record OrderRequestDto(
        @Schema(description = "Owner(user) id", example = "1")
        @NotNull(message = "{user_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer userId,

        @Schema(description = "Order status", example = "NEW")
        @NotNull(message = "{status.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{status.length}", groups = {OnCreate.class, OnUpdate.class})
        String status
) {
}