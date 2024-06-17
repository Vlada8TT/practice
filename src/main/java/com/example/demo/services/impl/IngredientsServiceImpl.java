package com.example.demo.services.impl;

import com.example.demo.dto.requests.IngredientRequestDto;
import com.example.demo.dto.responses.IngredientResponseDto;
import com.example.demo.services.IngredientsService;
import java.util.List;

public class IngredientsServiceImpl implements IngredientsService {
    @Override
    public IngredientResponseDto createIngredient(IngredientRequestDto Ingredients) {
        return null;
    }

    @Override
    public IngredientResponseDto getIngredientById(int id) {
        return null;
    }

    @Override
    public List<IngredientResponseDto> getAllIngredients() {
        return null;
    }

    @Override
    public IngredientResponseDto updateIngredient(int id, IngredientRequestDto Ingredients) {
        return null;
    }

    @Override
    public void deleteIngredient(int id) {

    }
}
