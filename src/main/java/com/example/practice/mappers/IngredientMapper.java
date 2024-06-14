package com.example.practice.mappers;


import com.example.practice.dto.IngredientDto;
import com.example.practice.persistence.entities.Ingredient;

public interface IngredientMapper {
    IngredientDto toDto (Ingredient ingredient);
    Ingredient toEntity(IngredientDto dto);
}
