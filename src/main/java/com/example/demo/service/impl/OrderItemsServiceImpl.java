package com.example.demo.service.impl;

import com.example.demo.dto.request.OrderItemRequestDto;
import com.example.demo.dto.response.OrderItemResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.persistence.entity.*;
import com.example.demo.repositories.OrderItemRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public OrderItemResponseDto createOrderItem(OrderItemRequestDto orderItemRequestDto) {

        OrderItem orderItem = orderItemMapper.toEntity(orderItemRequestDto);
        Order order = orderRepository.findById(orderItemRequestDto.orderId())
                .orElseThrow(() -> new EntityNotFoundException("order",orderItemRequestDto.orderId()));
        Product product = productRepository.findById(orderItemRequestDto.productId())
                .orElseThrow(() -> new EntityNotFoundException("product",orderItemRequestDto.productId()));
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemResponseDto> getAllOrderItems() {

        return orderItemMapper.toDto(orderItemRepository.findAll());
    }

    @Override
    @Transactional
    public OrderItemResponseDto updateOrderItem(int id, OrderItemRequestDto orderItemRequestDto) {

        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order item",id));
        updateOrderItemFields(orderItem,orderItemRequestDto);
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    @Transactional
    public void deleteOrderItem(int id) {

        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order item",id));
        orderItemRepository.delete(orderItem);
    }

    private void updateOrderItemFields(OrderItem orderItem, OrderItemRequestDto orderItemRequestDto){

        Order order = orderRepository.findById(orderItemRequestDto.orderId())
                .orElseThrow(() -> new EntityNotFoundException("order",orderItemRequestDto.orderId()));
        Product product = productRepository.findById(orderItemRequestDto.productId())
                .orElseThrow(() -> new EntityNotFoundException("product",orderItemRequestDto.productId()));
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemRequestDto.quantity());
    }
}