package com.example.demo.service.impl;


import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.service.OrdersService;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public OrderResponseDto createOrder(OrderRequestDto orders) {
        return null;
    }

    @Override
    public OrderResponseDto getOrdersById(int id) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderResponseDto updateOrders(int id, OrderRequestDto orders) {
        return null;
    }

    @Override
    public void deleteOrders(int id) {

    }
}
