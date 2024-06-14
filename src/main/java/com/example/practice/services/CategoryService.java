package com.example.practice.services;

import com.example.practice.models.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);
}