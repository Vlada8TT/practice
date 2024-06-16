package com.example.demo.mappers;

import com.example.demo.persistence.entity.Product;
import com.example.demo.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto (Product product);
    Product toEntity(ProductDto dto);
}
