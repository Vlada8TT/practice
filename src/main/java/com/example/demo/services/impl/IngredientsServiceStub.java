package com.example.demo.services.impl;

import com.example.demo.services.IngredientsService;
import com.example.demo.persistence.entity.Ingredient;

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
