package com.example.demo.mapper;


import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);

    void updateCategoryFromDto(CategoryRequestDto categoryRequestDto, @MappingTarget Category category);

    List<CategoryResponseDto> toDto(List<Category> category);

    Category toEntity(CategoryRequestDto dto);
}