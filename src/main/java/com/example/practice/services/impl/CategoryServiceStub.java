package com.example.practice.services.impl;

import com.example.practice.models.Category;
import com.example.practice.services.CategoryService;

import java.util.List;
import java.util.concurrent.Callable;

public class CategoryServiceStub implements CategoryService {
    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category getCategoryById(int id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        return null;
    }

    @Override
    public void deleteCategory(int id) {

    }
}
