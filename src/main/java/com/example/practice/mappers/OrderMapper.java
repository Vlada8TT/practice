package com.example.practice.mappers;

import com.example.practice.dto.OrderDto;
import com.example.practice.persistence.entities.Order;

public interface OrderMapper {
    OrderDto toDto (Order order);
    Order toEntity(OrderDto dto);
}
