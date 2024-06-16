package com.example.demo.services;



import com.example.demo.persistence.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);
}