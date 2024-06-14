package com.example.practice.services.impl;

import com.example.practice.models.Order;
import com.example.practice.models.OrderItem;
import com.example.practice.services.OrderItemsService;

import java.util.List;

public class OrderItemsServiceStub implements OrderItemsService {
    @Override
    public OrderItem createOrderItems(OrderItem orderItems) {
        return null;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return null;
    }

    @Override
    public Order updateOrderItems(int id, OrderItem orderItems) {
        return null;
    }

    @Override
    public void deleteOrderItems(int id) {

    }
}
