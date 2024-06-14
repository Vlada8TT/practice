package com.example.practice.services;


import com.example.practice.models.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductsService {
    Product createProducts(Product products);
    Product getProductsById(int id);
    List<Product> getAllProducts();
    Product updateProducts(int id, Product products);
    void deleteProducts(int id);
}
