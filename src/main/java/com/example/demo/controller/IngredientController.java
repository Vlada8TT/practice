package com.example.demo.controller;

import com.example.demo.dto.request.IngredientRequestDto;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import com.example.demo.service.IngredientService;
import com.example.demo.service.impl.IngredientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
@Validated
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping("/ingredient")
    public IngredientResponseDto createIngredient(
            @Validated(OnCreate.class) @RequestBody IngredientRequestDto ingredientRequestDto) {
        return ingredientService.createIngredient(ingredientRequestDto);
    }

    @PutMapping("/{id}")
    public IngredientResponseDto update(
            @PathVariable int id,
            @Validated(OnUpdate.class) @RequestBody IngredientRequestDto ingredientRequestDto) {
        return ingredientService.updateIngredient(id, ingredientRequestDto);
    }

    @GetMapping("/{id}")
    public IngredientResponseDto getById(@PathVariable int id) {
        return ingredientService.getIngredientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
    }
}
