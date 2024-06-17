package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByCategory(Category category);
    Optional<Product> findByName(String name);

}
