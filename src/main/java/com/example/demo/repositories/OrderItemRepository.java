package com.example.demo.repositories;


import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    Optional<OrderItem> findByProduct(Product product);

}
