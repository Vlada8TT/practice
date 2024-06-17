package com.example.demo.service;


import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductsService {
    ProductResponseDto createProducts(ProductRequestDto products);

    ProductResponseDto getProductsById(int id);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto updateProducts(int id, ProductRequestDto products);

    void deleteProducts(int id);
}