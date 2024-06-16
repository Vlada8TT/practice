package com.example.demo.mappers;

import com.example.demo.persistence.entity.Order;
import com.example.demo.dto.OrderDto;

public interface OrderMapper {
    OrderDto toDto (Order order);
    Order toEntity(OrderDto dto);
}
