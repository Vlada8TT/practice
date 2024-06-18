package com.example.demo.service;

import com.example.demo.dto.request.IngredientRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;

import java.util.List;

public interface IngredientService {
    IngredientResponseDto createIngredient(IngredientRequestDto Ingredients);

    IngredientResponseDto getIngredientById(int id);

    List<IngredientResponseDto> getAllIngredients();

    IngredientResponseDto updateIngredient(int id, IngredientRequestDto Ingredient);

    void deleteIngredient(int id);
}