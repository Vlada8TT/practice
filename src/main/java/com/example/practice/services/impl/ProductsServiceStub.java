package com.example.practice.services.impl;

import com.example.practice.persistence.entities.Product;
import com.example.practice.services.ProductsService;

import java.util.List;

public class ProductsServiceStub implements ProductsService {
    @Override
    public Product createProducts(Product products) {
        return null;
    }

    @Override
    public Product getProductsById(int id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProducts(int id, Product products) {
        return null;
    }

    @Override
    public void deleteProducts(int id) {

    }
}
