package com.example.practice.mappers;

import com.example.practice.dto.ProductDto;
import com.example.practice.persistence.entities.Product;

public interface ProductMapper {
    ProductDto toDto (Product product);
    Product toEntity(ProductDto dto);
}
