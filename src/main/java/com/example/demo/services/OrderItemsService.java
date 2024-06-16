package com.example.demo.services;


import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.OrderItem;

import java.util.List;

public interface OrderItemsService {
    OrderItem createOrderItems(OrderItem orderItems);
    List<OrderItem> getAllOrderItems();
    Order updateOrderItems(int id, OrderItem orderItems );
    void deleteOrderItems(int id);
}
