package com.example.demo.mappers;


import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.IngredientResponseDto;
import com.example.demo.persistence.entity.Ingredient;
import com.example.demo.dto.requests.IngredientRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientResponseDto toDto (Ingredient ingredient);
    List<IngredientResponseDto> toDto (List<Ingredient> ingredient);
    Ingredient toEntity(IngredientRequestDto dto);
}
