package com.example.practice.mappers;


import com.example.practice.dto.CategoryDto;
import com.example.practice.persistence.entities.Category;

public interface CategoryMapper {
    CategoryDto toDto (Category category);
    Category toEntity(CategoryDto dto);
}
