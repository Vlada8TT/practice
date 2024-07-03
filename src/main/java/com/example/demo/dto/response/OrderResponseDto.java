package com.example.demo.dto.response;

import java.sql.Timestamp;

public record OrderResponseDto(
        Integer id,

        Integer userId,

        Timestamp orderDate,

        String status
) {
}