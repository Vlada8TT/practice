package com.example.practice.services.impl;

import com.example.practice.persistence.entities.Category;
import com.example.practice.services.CategoryService;

import java.util.List;


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
