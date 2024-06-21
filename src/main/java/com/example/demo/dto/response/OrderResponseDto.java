package com.example.demo.dto.response;

import java.time.LocalDateTime;

public record OrderResponseDto(
        Integer id,

        Integer userId,

        LocalDateTime orderDate,

        String status
) {
}