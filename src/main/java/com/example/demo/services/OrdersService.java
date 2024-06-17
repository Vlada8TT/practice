package com.example.demo.services;

import com.example.demo.dto.requests.OrderRequestDto;
import com.example.demo.dto.responses.OrderResponseDto;
import com.example.demo.persistence.entity.Order;

import java.util.List;

public interface OrdersService {
    OrderResponseDto createOrder(OrderRequestDto orders );
    OrderResponseDto getOrdersById(int id);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto updateOrders(int id, OrderRequestDto orders );
    void deleteOrders(int id);
}
