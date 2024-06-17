package com.example.demo.service;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;

import java.util.List;

public interface OrdersService {
    OrderResponseDto createOrder(OrderRequestDto orders);

    OrderResponseDto getOrdersById(int id);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto updateOrders(int id, OrderRequestDto orders);

    void deleteOrders(int id);
}