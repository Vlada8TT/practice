package com.example.demo.service.impl;


import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.service.OrderService;
import java.util.List;

public class OrdersServiceImpl implements OrderService {
    @Override
    public OrderResponseDto createOrder(OrderRequestDto order) {
        return null;
    }

    @Override
    public OrderResponseDto getOrderById(int id) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderResponseDto updateOrder(int id, OrderRequestDto order) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}