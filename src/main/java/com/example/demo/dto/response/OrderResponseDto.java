package com.example.demo.dto.response;

import java.time.LocalDateTime;

public record OrderResponseDto(
        Integer id,

        Integer user_id,

        LocalDateTime time,

        String status
) {
}