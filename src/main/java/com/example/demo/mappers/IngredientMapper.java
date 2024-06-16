package com.example.demo.mappers;


import com.example.demo.persistence.entity.Ingredient;
import com.example.demo.dto.IngredientDto;

public interface IngredientMapper {
    IngredientDto toDto (Ingredient ingredient);
    Ingredient toEntity(IngredientDto dto);
}
