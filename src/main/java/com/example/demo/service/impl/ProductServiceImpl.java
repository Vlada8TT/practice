package com.example.demo.service.impl;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.persistence.entity.*;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.IngredientRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.util.ExceptionSourceName.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final IngredientRepository ingredientRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        log.info("Creating product");
        log.info("Name uniqueness checking...");
        checkIfNameUnique(productRequestDto);
        Product product = productMapper.toEntity(productRequestDto);
        product.setCategory(findCategoryById(productRequestDto));
        List<Ingredient> ingredients = productRequestDto.ingredientsId().stream()
                .map(this::findIngredientById)
                .toList();
        product.setIngredients(ingredients);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getProductById(int id) {
        log.info("Retrieving product by id {}", id);
        return productMapper.toDto(findProductById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getAllProducts() {
        log.info("Retrieving all products");
        return productMapper.toDto(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(int id, ProductRequestDto productRequestDto) {
        log.info("Updating product with id {}", id);
        Product product = findProductById(id);
        if (!productRequestDto.name().equals(product.getName())) {
            log.info("Name uniqueness checking...");
            checkIfNameUnique(productRequestDto);
        }
        productMapper.updateProductFromDto(productRequestDto,product);
        product.setCategory(findCategoryById(productRequestDto));
        List<Ingredient> ingredients = productRequestDto.ingredientsId().stream()
                .map(this::findIngredientById)
                .toList();
        List<Ingredient> modifiableIngredientsList = new ArrayList<>(ingredients);
        product.setIngredients(modifiableIngredientsList);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        log.info("Deleting product with id {}", id);
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Ingredient findIngredientById(int ingredientId){
        return ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> {
                    log.error("Ingredient with id {} was not found", ingredientId);
                    return new EntityNotFoundException(INGREDIENT, ingredientId);
                });
    }

    private Product findProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product with id {} was not found", id);
                    return new EntityNotFoundException(PRODUCT, id);
                });
    }

    private Category findCategoryById(ProductRequestDto productRequestDto) {
        return categoryRepository.findById(productRequestDto.categoryId())
                .orElseThrow(() -> {
                    log.error("Category with id {} was not found", productRequestDto.categoryId());
                    return new EntityNotFoundException(CATEGORY,productRequestDto.categoryId());
                });
    }

    private void checkIfNameUnique(ProductRequestDto productRequestDto){
        if (productRepository.existsByName(productRequestDto.name())){
            log.error("Product with name {} already exists",
                    productRequestDto.name(),
                    new ResourceAlreadyExistsException(PRODUCT,productRequestDto.name()));
            throw new ResourceAlreadyExistsException(PRODUCT,productRequestDto.name());
        }
    }
}