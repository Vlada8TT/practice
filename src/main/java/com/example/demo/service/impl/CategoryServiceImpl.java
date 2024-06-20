package com.example.demo.service.impl;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.persistence.entity.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.toEntity(categoryRequestDto);
        checkIfNameUnique(categoryRequestDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDto getCategoryById(int id) {
        return categoryMapper.toDto(findCategoryById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> getAllCategories() {
        return categoryMapper.toDto(categoryRepository.findAll());
    }

    @Override
    @Transactional
    public CategoryResponseDto updateCategory(int id, CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.toEntity(categoryRequestDto);
        checkIfNameUnique(categoryRequestDto);
        updateCategoryFields(category, categoryRequestDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        Category category = findCategoryById(id);
        categoryRepository.delete(category);
    }

    private void updateCategoryFields(Category category, CategoryRequestDto categoryRequestDto){
        category = categoryMapper.toEntity(categoryRequestDto);
    }

    private Category findCategoryById(int id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("category", id));
    }

    private void checkIfNameUnique(CategoryRequestDto categoryRequestDto){
        if(categoryRepository.existsByName(categoryRequestDto.name())){
            throw new ResourceAlreadyExistsException("category",categoryRequestDto.name());
        }
    }
}