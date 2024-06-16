package com.example.demo.mappers;

import com.example.demo.persistence.entity.Product;
import com.example.demo.dto.ProductDto;

public interface ProductMapper {
    ProductDto toDto (Product product);
    Product toEntity(ProductDto dto);
}
