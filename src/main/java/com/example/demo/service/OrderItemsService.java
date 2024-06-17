package com.example.demo.service;

import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.response.OrderItemResponseDto;

import java.util.List;

public interface OrderItemsService {
    OrderItemResponseDto createOrderItems(OrderItemRequestDto orderItems);

    List<OrderItemResponseDto> getAllOrderItems();

    OrderItemResponseDto updateOrderItems(int id, OrderItemRequestDto orderItems);

    void deleteOrderItems(int id);
}