package com.example.practice.services.impl;

import com.example.practice.models.Ingredient;
import com.example.practice.services.IngredientsService;

import java.util.List;

public class IngredientsServiceStub implements IngredientsService {
    @Override
    public Ingredient createIngredient(Ingredient Ingredients) {
        return null;
    }

    @Override
    public Ingredient getIngredientById(int id) {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public Ingredient updateIngredient(int id, Ingredient Ingredients) {
        return null;
    }

    @Override
    public void deleteIngredient(int id) {

    }
}
