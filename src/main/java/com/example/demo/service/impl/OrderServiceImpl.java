package com.example.demo.service.impl;


import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
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