package com.example.demo.mapper;


import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.persistence.entity.Category;
import com.example.demo.dto.request.CategoryRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);

    List<CategoryResponseDto> toDto(List<Category> category);

    Category toEntity(CategoryRequestDto dto);
}