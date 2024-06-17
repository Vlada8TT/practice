package com.example.demo.services;


import com.example.demo.dto.requests.OrderItemRequestDto;
import com.example.demo.dto.responses.OrderItemResponseDto;
import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.OrderItem;

import java.util.List;

public interface OrderItemsService {
    OrderItemResponseDto createOrderItems(OrderItemRequestDto orderItems);
    List<OrderItemResponseDto> getAllOrderItems();
    OrderItemResponseDto updateOrderItems(int id, OrderItemRequestDto orderItems );
    void deleteOrderItems(int id);
}
