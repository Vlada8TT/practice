package com.example.demo.services;


import com.example.demo.persistence.entity.Ingredient;

import java.util.List;

public interface IngredientsService {
    Ingredient createIngredient(Ingredient Ingredients );
    Ingredient getIngredientById(int id);
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(int id, Ingredient Ingredients );
    void deleteIngredient(int id);
}