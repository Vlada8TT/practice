package com.example.demo.controller;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ProductResponseDto createProduct(
            @Validated(OnCreate.class) @RequestBody ProductRequestDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable int id,
                                     @Validated(OnUpdate.class)
                                     @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}