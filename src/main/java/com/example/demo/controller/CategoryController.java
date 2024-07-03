package com.example.demo.controller;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/order")
    public CategoryResponseDto createOrder(
            @Validated(OnCreate.class) @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.updateCategory(id, categoryRequestDto);
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
