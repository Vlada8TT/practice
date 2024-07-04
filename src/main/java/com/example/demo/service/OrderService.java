package com.example.demo.service;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto order);

    OrderResponseDto getOrderById(int id);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto updateOrder(int id, OrderRequestDto order);

    List<OrderResponseDto> getOrdersByUserId(int userId);

    void deleteOrder(int id);
}