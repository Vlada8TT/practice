package com.example.demo.controller;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createPizza(@Valid @RequestBody ProductRequestDto productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllPizzas() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

        @GetMapping("/{id}")
        public ResponseEntity<ProductResponseDto> getPizzaById(@PathVariable int id) {
            return ResponseEntity.ok(productService.getProductById(id));
        }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteProduct(id);
    }

}