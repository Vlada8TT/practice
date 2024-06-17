package com.example.demo.services.impl;

import com.example.demo.dto.requests.ProductRequestDto;
import com.example.demo.dto.responses.ProductResponseDto;
import com.example.demo.persistence.entity.Product;
import com.example.demo.services.ProductsService;

import java.util.List;

public class ProductsServiceStub implements ProductsService {
    @Override
    public ProductResponseDto createProducts(ProductRequestDto products) {
        return null;
    }

    @Override
    public ProductResponseDto getProductsById(int id) {
        return null;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDto updateProducts(int id, ProductRequestDto products) {
        return null;
    }

    @Override
    public void deleteProducts(int id) {

    }
}
