package com.example.demo.dto.response;

import java.math.BigDecimal;

public record ProductResponseDto(
        Integer id,

        String name,

        BigDecimal price,

        Integer categoryId,

        String imagePath
) {
}