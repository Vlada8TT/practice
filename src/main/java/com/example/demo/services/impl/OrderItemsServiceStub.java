package com.example.demo.services.impl;


import com.example.demo.dto.requests.OrderItemRequestDto;
import com.example.demo.dto.responses.OrderItemResponseDto;
import com.example.demo.dto.responses.OrderResponseDto;
import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.services.OrderItemsService;

import java.util.List;

public class OrderItemsServiceStub implements OrderItemsService {
    @Override
    public OrderItemResponseDto createOrderItems(OrderItemRequestDto orderItems) {
        return null;
    }

    @Override
    public List<OrderItemResponseDto> getAllOrderItems() {
        return null;
    }

    @Override
    public OrderResponseDto updateOrderItems(int id, OrderItemRequestDto orderItems) {
        return null;
    }

    @Override
    public void deleteOrderItems(int id) {

    }
}
