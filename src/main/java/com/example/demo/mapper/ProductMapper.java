package com.example.demo.mapper;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.persistence.entity.Category;
import com.example.demo.persistence.entity.Product;
import com.example.demo.dto.request.ProductRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductResponseDto toDto(Product product);

    void updateProductFromDto(ProductRequestDto productRequestDto, @MappingTarget Product product);

    List<ProductResponseDto> toDto(List<Product> product);

    Product toEntity(ProductRequestDto dto);
}