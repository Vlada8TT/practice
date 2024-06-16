package com.example.demo.services.impl;


import com.example.demo.services.OrdersService;
import com.example.demo.persistence.entity.Order;

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
