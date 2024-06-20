package com.example.demo.controller;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponseDto createProduct(@Validated(OnCreate.class) @RequestBody ProductRequestDto productDto) {
        ProductResponseDto createdProduct = productService.createProduct(productDto);
        return createdProduct;
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        List<ProductResponseDto> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable int id){
        ProductResponseDto product = productService.getProductById(id);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteProduct(id);
    }
}