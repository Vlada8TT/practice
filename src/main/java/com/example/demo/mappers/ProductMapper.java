package com.example.demo.mappers;

import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.ProductResponseDto;
import com.example.demo.persistence.entity.Product;
import com.example.demo.dto.requests.ProductRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto toDto (Product product);
    List<ProductResponseDto> toDto (List<Product> product);
    Product toEntity(ProductRequestDto dto);
}
