package com.example.practice.services;

import com.example.practice.models.OrderItem;
import com.example.practice.models.Order;

import java.util.List;

public interface OrderItemsService {
    OrderItem createOrderItems(OrderItem orderItems);
    List<OrderItem> getAllOrderItems();
    Order updateOrderItems(int id, OrderItem orderItems );
    void deleteOrderItems(int id);
}
