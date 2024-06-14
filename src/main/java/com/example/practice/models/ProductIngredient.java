package com.example.practice.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class ProductIngredient {
    @Getter
    @Setter
    @NotNull
    private Integer productId;
    @Getter
    @Setter

    @NotNull
    private Integer ingredientId;




}