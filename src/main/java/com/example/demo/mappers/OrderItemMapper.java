package com.example.demo.mappers;

import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.dto.OrderItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDto (OrderItem orderItem);
    OrderItem toEntity(OrderItemDto dto);
}
