package com.example.demo.mappers;

import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.dto.OrderItemDto;

public interface OrderItemMapper {
    OrderItemDto toDto (OrderItem orderItem);
    OrderItem toEntity(OrderItemDto dto);
}
