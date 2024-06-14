package com.example.practice.services;

import com.example.practice.models.OrderItem;
import com.example.practice.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderItemsService {
    OrderItem createOrderItems(OrderItem orderItems);
    List<OrderItem> getAllOrderItems();
    Order updateOrderItems(int id, OrderItem orderItems );
    void deleteOrderItems(int id);
}
