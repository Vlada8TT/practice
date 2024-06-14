package com.example.practice.services;



import com.example.practice.persistence.entities.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);
}