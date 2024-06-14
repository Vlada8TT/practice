package com.example.practice.dto;

import com.example.practice.dto.validation.OnCreate;
import com.example.practice.dto.validation.OnUpdate;
import com.example.practice.persistence.entities.Category;
import com.example.practice.persistence.entities.Image;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductDto {
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    private int id;

    @NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Name length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "Price must not be null.", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal price;

    @NotNull(message = "Category must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Category length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_ingredients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )

    @OneToOne
    private Image image;
}
