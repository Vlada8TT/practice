package com.example.demo.service;

import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.response.OrderItemResponseDto;

import java.util.List;

public interface OrderItemService {

    List<OrderItemResponseDto> getAllOrderItems();

    OrderItemResponseDto updateOrderItem(int id, OrderItemRequestDto orderItem);

    void addOrderItem(int orderId,OrderItemRequestDto orderItem);

    void deleteOrderItem(int id);
}