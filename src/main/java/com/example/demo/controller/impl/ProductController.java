package com.example.demo.controller.impl;

import com.example.demo.controller.ProductAPI;
import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController implements ProductAPI {
    private final ProductService productService;

    @PostMapping("/admin/create")
    public ProductResponseDto createProduct(
            @Validated(OnCreate.class) @RequestBody ProductRequestDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/permitall")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }   

    @GetMapping("/permitall/{id}")
    public ProductResponseDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/admin/{id}")
    public ProductResponseDto update(@PathVariable int id,
                                     @Validated(OnUpdate.class)
                                     @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/permitall/category/{categoryId}")
    public List<ProductResponseDto> getProductByCategoryId(@PathVariable int categoryId) {
        return productService.getAllProductsByCategoryId(categoryId);
    }
}