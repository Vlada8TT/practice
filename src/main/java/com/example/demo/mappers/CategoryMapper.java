package com.example.demo.mappers;


import com.example.demo.persistence.entity.Category;
import com.example.demo.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto (Category category);
    Category toEntity(CategoryDto dto);
}
