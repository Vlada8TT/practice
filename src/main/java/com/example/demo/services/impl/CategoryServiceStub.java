package com.example.demo.services.impl;

import com.example.demo.persistence.entity.Category;
import com.example.demo.services.CategoryService;

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
