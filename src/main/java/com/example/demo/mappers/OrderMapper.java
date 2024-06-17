package com.example.demo.mappers;

import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.OrderResponseDto;
import com.example.demo.persistence.entity.Order;
import com.example.demo.dto.requests.OrderRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponseDto toDto (Order order);
    List<OrderResponseDto> toDto (List<Order> order);
    Order toEntity(OrderRequestDto dto);
}
