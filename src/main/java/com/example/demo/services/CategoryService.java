package com.example.demo.services;



import com.example.demo.dto.requests.CategoryRequestDto;
import com.example.demo.dto.responses.CategoryResponseDto;
import com.example.demo.persistence.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto category);
    CategoryResponseDto getCategoryById(int id);
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto updateCategory(int id, CategoryRequestDto category);
    void deleteCategory(int id);
}