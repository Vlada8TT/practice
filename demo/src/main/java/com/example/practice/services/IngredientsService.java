package com.example.practice.services;

import com.example.practice.models.Ingredient;

import java.util.List;

public interface IngredientsService {
    Ingredient createIngredient(Ingredient Ingredients );
    Ingredient getIngredientById(int id);
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(int id, Ingredient Ingredients );
    void deleteIngredient(int id);
}