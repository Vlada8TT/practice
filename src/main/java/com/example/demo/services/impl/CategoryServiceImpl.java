package com.example.demo.services.impl;

import com.example.demo.dto.requests.CategoryRequestDto;
import com.example.demo.dto.responses.CategoryResponseDto;
import com.example.demo.services.CategoryService;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {
    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto category) {
        return null;
    }

    @Override
    public CategoryResponseDto getCategoryById(int id) {
        return null;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryResponseDto updateCategory(int id, CategoryRequestDto category) {
        return null;
    }

    @Override
    public void deleteCategory(int id) {

    }
}
