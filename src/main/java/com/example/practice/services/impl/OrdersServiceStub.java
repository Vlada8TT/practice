package com.example.practice.services.impl;

import com.example.practice.models.Order;
import com.example.practice.services.OrdersService;

import java.util.List;

public class OrdersServiceStub implements OrdersService {
    @Override
    public Order createOrder(Order orders) {
        return null;
    }

    @Override
    public Order getOrdersById(int id) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order updateOrders(int id, Order orders) {
        return null;
    }

    @Override
    public void deleteOrders(int id) {

    }
}
