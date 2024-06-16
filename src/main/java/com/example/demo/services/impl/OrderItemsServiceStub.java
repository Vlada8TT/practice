package com.example.demo.services.impl;


import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.services.OrderItemsService;

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
