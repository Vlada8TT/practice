package com.example.demo.service.impl;

import com.example.demo.dto.request.IngredientRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.IngredientMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.persistence.entity.Ingredient;
import com.example.demo.persistence.entity.Product;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.util.ExceptionSourceName.INGREDIENT;
import static com.example.demo.util.ExceptionSourceName.PRODUCT;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final ProductRepository productRepository;

    private final IngredientMapper ingredientMapper;

    @Override
    @Transactional
    public IngredientResponseDto createIngredient(IngredientRequestDto ingredientRequestDto) {
        log.info("Creating ingredient");
        checkIfNameUnique(ingredientRequestDto);
        Ingredient ingredient = ingredientMapper.toEntity(ingredientRequestDto);
        ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientResponseDto getIngredientById(int id) {
        log.info("Retrieving ingredient by id {}", id);
        return ingredientMapper.toDto(findIngredientById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientResponseDto> getAllIngredients() {
        log.info("Retrieving all ingredients");
        return ingredientMapper.toDto(ingredientRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientResponseDto> getAllIngredientsByProductId(int productId) {
        log.info("Retrieving all ingredients by product id");
        return ingredientMapper.toDto(findProductById(productId).getIngredients());
    }

    private Product findProductById(int id) {
        return  productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product with id {} was not found", id);
                    return new EntityNotFoundException(PRODUCT, id);
                });
    }

    @Override
    @Transactional
    public IngredientResponseDto updateIngredient(int id, IngredientRequestDto ingredientRequestDto) {
        log.info("Updating ingredient with id {}", id);
        Ingredient ingredient = findIngredientById(id);
        if (!ingredientRequestDto.name().equals(ingredient.getName())) {
            checkIfNameUnique(ingredientRequestDto);
        }
        ingredientMapper.updateIngredientFromDto(ingredientRequestDto, ingredient);
        ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    @Transactional
    public void deleteIngredient(int id) {
        log.info("Deleting ingredient with id {}", id);
        Ingredient ingredient = findIngredientById(id);
        ingredientRepository.delete(ingredient);
    }

    private Ingredient findIngredientById(int id) {
        return  ingredientRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Ingredient with id {} was not found", id);
                    return new EntityNotFoundException(INGREDIENT, id);
                });
    }

    private void checkIfNameUnique(IngredientRequestDto ingredientRequestDto) {
        log.info("Name uniqueness checking...");
        if (ingredientRepository.existsByName(ingredientRequestDto.name())) {
            log.error("Ingredient with name {} already exists",
                    ingredientRequestDto.name(),
                    new ResourceAlreadyExistsException(INGREDIENT, ingredientRequestDto.name()));
            throw new ResourceAlreadyExistsException(INGREDIENT, ingredientRequestDto.name());
        }
    }
}