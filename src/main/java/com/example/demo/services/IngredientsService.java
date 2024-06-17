package com.example.demo.services;


import com.example.demo.dto.requests.IngredientRequestDto;
import com.example.demo.dto.responses.IngredientResponseDto;
import com.example.demo.persistence.entity.Ingredient;

import java.util.List;

public interface IngredientsService {
    IngredientResponseDto createIngredient(IngredientRequestDto Ingredients );
    IngredientResponseDto getIngredientById(int id);
    List<IngredientResponseDto> getAllIngredients();
    IngredientResponseDto updateIngredient(int id, IngredientRequestDto Ingredients );
    void deleteIngredient(int id);
}