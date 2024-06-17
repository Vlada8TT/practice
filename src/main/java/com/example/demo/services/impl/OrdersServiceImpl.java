package com.example.demo.services.impl;


import com.example.demo.dto.requests.OrderRequestDto;
import com.example.demo.dto.responses.OrderResponseDto;
import com.example.demo.services.OrdersService;
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
