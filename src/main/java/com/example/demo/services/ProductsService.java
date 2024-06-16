package com.example.demo.services;


import com.example.demo.persistence.entity.Product;

import java.util.List;

public interface ProductsService {
    Product createProducts(Product products);
    Product getProductsById(int id);
    List<Product> getAllProducts();
    Product updateProducts(int id, Product products);
    void deleteProducts(int id);
}
