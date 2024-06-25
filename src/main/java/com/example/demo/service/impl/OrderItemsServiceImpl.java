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

import static com.example.demo.util.ExceptionSourceName.ORDER_ITEM;
import static com.example.demo.util.ExceptionSourceName.ORDER;
import static com.example.demo.util.ExceptionSourceName.PRODUCT;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void addOrderItem(int orderId, OrderItemRequestDto orderItemRequestDto) {
        OrderItem orderItem = orderItemMapper.toEntity(orderItemRequestDto);
        orderItem.setOrder(findOrderById(orderId));
        orderItem.setProduct(findProductById(orderItemRequestDto));
        orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemResponseDto> getAllOrderItems() {
        return orderItemMapper.toDto(orderItemRepository.findAll());
    }

    @Override
    @Transactional
    public OrderItemResponseDto updateOrderItem(int id, OrderItemRequestDto orderItemRequestDto) {
        OrderItem orderItem = findOrderItemById(id);
        orderItemMapper.updateOrderItemFromDto(orderItemRequestDto,orderItem);
        orderItem.setProduct(findProductById(orderItemRequestDto));
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    @Transactional
    public void deleteOrderItem(int id) {
        OrderItem orderItem = findOrderItemById(id);
        orderItemRepository.delete(orderItem);
    }


    private OrderItem findOrderItemById(int id){
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ORDER_ITEM,id));
    }

    private Product findProductById(OrderItemRequestDto orderItemRequestDto){
        return productRepository.findById(orderItemRequestDto.productId())
                .orElseThrow(() -> new EntityNotFoundException(PRODUCT,orderItemRequestDto.productId()));
    }

    private Order findOrderById(int id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ORDER,id));
    }
}