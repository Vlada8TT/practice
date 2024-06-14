package com.example.practice.services.impl;

import com.example.practice.models.ProductIngredient;
import com.example.practice.services.ProductIngredientsService;

import java.util.List;

public class ProductIngredientsServiceStub implements ProductIngredientsService {
    @Override
    public ProductIngredient addIngredientToProduct(ProductIngredient productIngredients) {
        return null;
    }

    @Override
    public void removeIngredientFromProduct(int productId, int ingredientId) {

    }

    @Override
    public List<ProductIngredient> getIngredientsByProductId(int productId) {
        return null;
    }
}
