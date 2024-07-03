package com.example.demo.mapper;


import com.example.demo.dto.request.IngredientRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;
import com.example.demo.persistence.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {
    IngredientResponseDto toDto(Ingredient ingredient);

    void updateIngredientFromDto(IngredientRequestDto ingredientRequestDto, @MappingTarget Ingredient ingredient);

    List<IngredientResponseDto> toDto(List<Ingredient> ingredient);

    Ingredient toEntity(IngredientRequestDto dto);
}