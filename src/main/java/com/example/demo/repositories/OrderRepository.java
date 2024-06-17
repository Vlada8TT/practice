package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByUser(User user);
    Optional<Order> findByStatus(String status);

}