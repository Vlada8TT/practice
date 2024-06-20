package com.example.demo.repositories;


import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserId(Integer userId);

    List<Order> findAllByStatus(OrderStatus status);
}