package com.example.demo.mappers;

import com.example.demo.persistence.entity.Order;
import com.example.demo.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto (Order order);
    Order toEntity(OrderDto dto);
}
