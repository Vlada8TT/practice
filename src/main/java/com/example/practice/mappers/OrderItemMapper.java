package com.example.practice.mappers;

import com.example.practice.dto.OrderItemDto;
import com.example.practice.persistence.entities.OrderItem;

public interface OrderItemMapper {
    OrderItemDto toDto (OrderItem orderItem);
    OrderItem toEntity(OrderItemDto dto);
}
