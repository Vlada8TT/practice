package com.example.demo.mapper;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.persistence.entity.Category;
import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.dto.request.OrderItemRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {
    OrderItemResponseDto toDto(OrderItem orderItem);

    void updateOrderItemFromDto(OrderItemRequestDto orderItemRequestDto, @MappingTarget OrderItem orderItem);

    List<OrderItemResponseDto> toDto(List<OrderItem> orderItem);

    OrderItem toEntity(OrderItemRequestDto dto);
}