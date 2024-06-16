package com.example.demo.mappers;


import com.example.demo.persistence.entity.Category;
import com.example.demo.dto.CategoryDto;

public interface CategoryMapper {
    CategoryDto toDto (Category category);
    Category toEntity(CategoryDto dto);
}
