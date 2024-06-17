package com.example.demo.mappers;

import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.OrderItemResponseDto;
import com.example.demo.persistence.entity.OrderItem;
import com.example.demo.dto.requests.OrderItemRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemResponseDto toDto (OrderItem orderItem);
    List<OrderItemResponseDto> toDto (List<OrderItem> orderItem);
    OrderItem toEntity(OrderItemRequestDto dto);
}
