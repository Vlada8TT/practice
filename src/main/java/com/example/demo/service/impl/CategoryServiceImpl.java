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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.util.ExceptionSourceName.CATEGORY;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        log.info("Creating category");
        log.info("Name uniqueness checking...");
        checkIfNameUnique(categoryRequestDto);
        Category category = categoryMapper.toEntity(categoryRequestDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDto getCategoryById(int id) {
        log.info("Retrieving category by id {}", id);
        return categoryMapper.toDto(findCategoryById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> getAllCategories() {
        log.info("Retrieving all categories");
        return categoryMapper.toDto(categoryRepository.findAll());
    }

    @Override
    @Transactional
    public CategoryResponseDto updateCategory(int id, CategoryRequestDto categoryRequestDto) {
        log.info("Updating category with id {}", id);
        Category category = findCategoryById(id);
        if (!categoryRequestDto.name().equals(category.getName())) {
            log.info("Name uniqueness checking...");
            checkIfNameUnique(categoryRequestDto);
        }
        categoryMapper.updateCategoryFromDto(categoryRequestDto,category);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        log.info("Deleting category with id {}", id);
        Category category = findCategoryById(id);
        categoryRepository.delete(category);
    }

    private Category findCategoryById(int id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Category with id {} was not found", id);
                    return new EntityNotFoundException(CATEGORY, id);
                });
    }

    private void checkIfNameUnique(CategoryRequestDto categoryRequestDto){
        if (categoryRepository.existsByName(categoryRequestDto.name())){
            log.error("Category with name {} already exists",
                    categoryRequestDto.name(),
                    new ResourceAlreadyExistsException(CATEGORY,categoryRequestDto.name()));
            throw new ResourceAlreadyExistsException(CATEGORY,categoryRequestDto.name());
        }
    }
}