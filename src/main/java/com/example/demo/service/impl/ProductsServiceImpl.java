package com.example.demo.service.impl;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.persistence.entity.*;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ImageRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        product.setCategory(findCategoryById(productRequestDto));
        product.setImage(findImageById(productRequestDto));
        checkIfNameUnique(productRequestDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getProductById(int id) {
        return productMapper.toDto(findProductById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getAllProducts() {
        return productMapper.toDto(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(int id, ProductRequestDto productRequestDto) {
        Product product = findProductById(id);
        checkIfNameUnique(productRequestDto);
        updateProductFields(product,productRequestDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private void updateProductFields(Product product, ProductRequestDto productRequestDto){
        product = productMapper.toEntity(productRequestDto);
        product.setImage(findImageById(productRequestDto));
        product.setCategory(findCategoryById(productRequestDto));
    }

    private Product findProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product", id));
    }

    private Image findImageById(ProductRequestDto productRequestDto) {
        return imageRepository.findById(productRequestDto.imageId())
                .orElseThrow(() -> new EntityNotFoundException("image",productRequestDto.imageId()));
    }

    private Category findCategoryById(ProductRequestDto productRequestDto) {
        return categoryRepository.findById(productRequestDto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("category",productRequestDto.categoryId()));
    }

    private void checkIfNameUnique(ProductRequestDto productRequestDto){
        if(productRepository.existsByName(productRequestDto.name())){
            throw new ResourceAlreadyExistsException("product",productRequestDto.name());
        }
    }
}