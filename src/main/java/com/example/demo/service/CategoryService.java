package com.example.demo.service;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto category);

    CategoryResponseDto getCategoryById(int id);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto updateCategory(int id, CategoryRequestDto category);

    void deleteCategory(int id);
}