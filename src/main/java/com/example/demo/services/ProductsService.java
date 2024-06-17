package com.example.demo.services;


import com.example.demo.dto.requests.ProductRequestDto;
import com.example.demo.dto.responses.ProductResponseDto;
import com.example.demo.persistence.entity.Product;

import java.util.List;

public interface ProductsService {
    ProductResponseDto createProducts(ProductRequestDto products);
    ProductResponseDto getProductsById(int id);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto updateProducts(int id, ProductRequestDto products);
    void deleteProducts(int id);
}
