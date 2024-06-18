package com.example.demo.mapper;

import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.dto.request.OrderItemRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {
    OrderItemResponseDto toDto(OrderItem orderItem);

    List<OrderItemResponseDto> toDto(List<OrderItem> orderItem);

    OrderItem toEntity(OrderItemRequestDto dto);
}