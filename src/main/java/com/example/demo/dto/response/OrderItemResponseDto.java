package com.example.demo.dto.response;

public record OrderItemResponseDto(
        Integer id,

        Integer orderId,

        Integer productId,

        Integer quantity
) {
}