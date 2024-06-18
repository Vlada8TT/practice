package com.example.demo.service;


import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto product);

    ProductResponseDto getProductById(int id);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto updateProduct(int id, ProductRequestDto product);

    void deleteProduct(int id);
}