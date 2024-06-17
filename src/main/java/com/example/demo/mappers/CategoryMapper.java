package com.example.demo.mappers;


import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.CategoryResponseDto;
import com.example.demo.persistence.entity.Category;
import com.example.demo.dto.requests.CategoryRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDto toDto (Category category);
    List<CategoryResponseDto> toDto (List<Category> category);
    Category toEntity(CategoryRequestDto dto);
}
