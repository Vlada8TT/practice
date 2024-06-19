package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;

public record OrderItemRequestDto(

        @NotNull(message = "{user_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer orderId,

        @NotNull(message = "{product_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer productId,

        @NotNull(message = "{quantity.notnull}", groups = {OnCreate.class, OnUpdate.class})
        Integer quantity
) {
}