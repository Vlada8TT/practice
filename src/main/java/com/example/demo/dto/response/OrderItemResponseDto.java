package com.example.demo.dto.response;

import lombok.Data;


public record OrderItemResponseDto(
        Integer id,

        Integer user_id,

        Integer product_id,

        Integer quantity
) {
}
