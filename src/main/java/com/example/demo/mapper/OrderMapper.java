package com.example.demo.mapper;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.persistence.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderResponseDto toDto(Order order);

    void updateOrderFromDto(OrderRequestDto orderRequestDto, @MappingTarget Order order);

    List<OrderResponseDto> toDto(List<Order> order);

    Order toEntity(OrderRequestDto dto);
}