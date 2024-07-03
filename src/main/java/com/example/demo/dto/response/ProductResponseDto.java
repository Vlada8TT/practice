package com.example.demo.dto.response;

import com.example.demo.persistence.entity.Category;

import java.math.BigDecimal;

public record ProductResponseDto(
        Integer id,

        String name,

        BigDecimal price,

        Category category,

        String imagePath
) {
}