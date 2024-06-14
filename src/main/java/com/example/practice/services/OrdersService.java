package com.example.practice.services;

import com.example.practice.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrdersService {
    Order createOrder(Order orders );
    Order getOrdersById(int id);
    List<Order> getAllOrders();
    Order updateOrders(int id, Order orders );
    void deleteOrders(int id);
}
