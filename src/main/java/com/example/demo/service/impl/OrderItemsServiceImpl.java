package com.example.demo.service.impl;


import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemsServiceImpl implements OrderItemService {
    @Override
    public OrderItemResponseDto createOrderItem(OrderItemRequestDto orderItem) {
        return null;
    }

    @Override
    public List<OrderItemResponseDto> getAllOrderItems() {
        return null;
    }

    @Override
    public OrderItemResponseDto updateOrderItem(int id, OrderItemRequestDto orderItem) {
        return null;
    }

    @Override
    public void deleteOrderItem(int id) {

    }
}