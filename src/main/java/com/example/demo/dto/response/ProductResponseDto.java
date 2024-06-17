package com.example.demo.dto.response;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {
    private Integer id;

    private String name;

    private BigDecimal price;

    private CategoryResponseDto category;

    @ManyToMany
    @JoinTable(
            name = "product_ingredients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )

    @OneToOne
    private ImageResponseDto image;
}
