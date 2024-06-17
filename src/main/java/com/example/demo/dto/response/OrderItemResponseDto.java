package com.example.demo.dto.response;

import lombok.Data;

@Data
public class OrderItemResponseDto {
    private Integer id;

    private Integer user_id;

    private Integer product_id;

    private Integer quantity;
}
