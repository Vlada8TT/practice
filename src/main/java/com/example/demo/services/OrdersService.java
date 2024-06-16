package com.example.demo.services;

import com.example.demo.persistence.entity.Order;

import java.util.List;

public interface OrdersService {
    Order createOrder(Order orders );
    Order getOrdersById(int id);
    List<Order> getAllOrders();
    Order updateOrders(int id, Order orders );
    void deleteOrders(int id);
}
