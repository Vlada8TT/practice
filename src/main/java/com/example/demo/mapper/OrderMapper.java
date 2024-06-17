package com.example.demo.mapper;

import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.persistence.entity.Order;
import com.example.demo.dto.request.OrderRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponseDto toDto(Order order);

    List<OrderResponseDto> toDto(List<Order> order);

    Order toEntity(OrderRequestDto dto);
}