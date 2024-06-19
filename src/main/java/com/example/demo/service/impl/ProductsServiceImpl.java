package com.example.demo.service.impl;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.exception.EntityNotFoundException;
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
        Image image = imageRepository.findById(productRequestDto.imageId())
                .orElseThrow(() -> new EntityNotFoundException("image",productRequestDto.imageId()));
        Category category = categoryRepository.findById(productRequestDto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("category",productRequestDto.categoryId()));
        product.setCategory(category);
        product.setImage(image);
        if(productRepository.findByName(productRequestDto.name()).isPresent()){
            throw new ResourceAlreadyExistsException("product",productRequestDto.name());
        }
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getProductById(int id) {

        return productMapper.toDto(productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> getAllProducts() {

        return productMapper.toDto(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(int id, ProductRequestDto productRequestDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product",id));
        if(productRepository.findByName(productRequestDto.name()).isPresent()){
            throw new ResourceAlreadyExistsException("product",productRequestDto.name());
        }
        updateProductFields(product,productRequestDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product", id));
        productRepository.delete(product);
    }

    private void updateProductFields(Product product, ProductRequestDto productRequestDto){

        Image image = imageRepository.findById(productRequestDto.imageId())
                .orElseThrow(() -> new EntityNotFoundException("image",productRequestDto.imageId()));
        Category category = categoryRepository.findById(productRequestDto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("category",productRequestDto.categoryId()));
        product.setName(productRequestDto.name());
        product.setPrice(productRequestDto.price());
        product.setImage(image);
        product.setCategory(category);
    }
}