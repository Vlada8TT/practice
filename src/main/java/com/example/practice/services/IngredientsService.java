package com.example.practice.services;

import com.example.practice.models.Ingredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IngredientsService {
    Ingredient createIngredient(Ingredient Ingredients );
    Ingredient getIngredientById(int id);
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(int id, Ingredient Ingredients );
    void deleteIngredient(int id);
}