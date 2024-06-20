package com.example.demo.service.impl;

import com.example.demo.dto.request.IngredientRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.IngredientMapper;
import com.example.demo.persistence.entity.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Override
    @Transactional
    public IngredientResponseDto createIngredient(IngredientRequestDto ingredientRequestDto) {

        Ingredient ingredient = ingredientMapper.toEntity(ingredientRequestDto);
        checkIfNameUnique(ingredientRequestDto);
        ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientResponseDto getIngredientById(int id) {

        return ingredientMapper.toDto(findIngredientById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientResponseDto> getAllIngredients() {

        return ingredientMapper.toDto(ingredientRepository.findAll());
    }

    @Override
    @Transactional
    public IngredientResponseDto updateIngredient(int id, IngredientRequestDto ingredientRequestDto) {
        Ingredient ingredient = ingredientMapper.toEntity(ingredientRequestDto);
        checkIfNameUnique(ingredientRequestDto);
        updateIngredientFields(ingredient,ingredientRequestDto);
        ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    @Transactional
    public void deleteIngredient(int id) {
        Ingredient ingredient = findIngredientById(id);
        ingredientRepository.delete(ingredient);
    }

    private void updateIngredientFields(Ingredient ingredient, IngredientRequestDto ingredientRequestDto){
        ingredient = ingredientMapper.toEntity(ingredientRequestDto);
    }

    private Ingredient findIngredientById(int id){
        return  ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ingredient", id));
    }

    private void checkIfNameUnique(IngredientRequestDto ingredientRequestDto){
        if(ingredientRepository.existsByName(ingredientRequestDto.name())){
            throw new ResourceAlreadyExistsException("ingredient",ingredientRequestDto.name());
        }
    }
}