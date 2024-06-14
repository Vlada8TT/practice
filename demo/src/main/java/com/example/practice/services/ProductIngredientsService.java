package com.example.practice.services;

import com.example.practice.models.ProductIngredient;

import java.util.List;

public interface ProductIngredientsService {
    ProductIngredient addIngredientToProduct(ProductIngredient productIngredients);
    void removeIngredientFromProduct(int productId, int ingredientId);
    List<ProductIngredient> getIngredientsByProductId(int productId);
}