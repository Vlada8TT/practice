package com.example.demo.repositories;


import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryId(Integer categoryId);

    boolean existsByName(String name);

    Optional<Product> findByName(String name);
}
