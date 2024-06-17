package com.example.demo.dto.response;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;


public record ProductResponseDto(
        Integer id,

        String name,

        BigDecimal price,

        CategoryResponseDto category,

        @ManyToMany
        @JoinTable(
                name = "product_ingredients",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id")
        )

        @OneToOne
        ImageResponseDto image
) {
}
