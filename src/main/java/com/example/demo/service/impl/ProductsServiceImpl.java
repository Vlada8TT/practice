package com.example.demo.service.impl;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductService {
    @Override
    public ProductResponseDto createProduct(ProductRequestDto product) {
        return null;
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        return null;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDto updateProduct(int id, ProductRequestDto product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }
}