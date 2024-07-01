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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.util.ExceptionSourceName.ORDER_ITEM;
import static com.example.demo.util.ExceptionSourceName.ORDER;
import static com.example.demo.util.ExceptionSourceName.PRODUCT;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void addOrderItem(int orderId, OrderItemRequestDto orderItemRequestDto) {
        log.info("Adding order item to order with id {}", orderId);
        OrderItem orderItem = orderItemMapper.toEntity(orderItemRequestDto);
        orderItem.setOrder(findOrderById(orderId));
        orderItem.setProduct(findProductById(orderItemRequestDto));
        orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemResponseDto> getAllOrderItems() {
        log.info("Retrieving all order items");
        return orderItemMapper.toDto(orderItemRepository.findAll());
    }

    @Override
    @Transactional
    public OrderItemResponseDto updateOrderItem(int id, OrderItemRequestDto orderItemRequestDto) {
        log.info("Updating order item with id {}", id);
        OrderItem orderItem = findOrderItemById(id);
        orderItemMapper.updateOrderItemFromDto(orderItemRequestDto, orderItem);
        orderItem.setProduct(findProductById(orderItemRequestDto));
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    @Transactional
    public void deleteOrderItem(int id) {
        log.info("Deleting order item with id {}", id);
        OrderItem orderItem = findOrderItemById(id);
        orderItemRepository.delete(orderItem);
    }

    @Override
    @Transactional
    public void incrementOrderItemQuantity(int id) {
        log.info("Incrementing order item quantity");
        OrderItem orderItem = findOrderItemById(id);
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional
    public void decrementOrderItemQuantity(int id) {
        log.info("Decrementing order item quantity");
        OrderItem orderItem = findOrderItemById(id);
        orderItem.setQuantity(orderItem.getQuantity() - 1);
        if (orderItem.getQuantity() <= 0) {
            log.info("Order item quantity <= 0 and will be dematerialized");
            deleteOrderItem(id);
            return;
        }
        orderItemRepository.save(orderItem);
    }

    private OrderItem findOrderItemById(int id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Order item with id {} was not found", id);
                    return new EntityNotFoundException(ORDER_ITEM, id);
                });
    }

    private Product findProductById(OrderItemRequestDto orderItemRequestDto) {
        return productRepository.findById(orderItemRequestDto.productId())
                .orElseThrow(() -> {
                    log.error("Product with id {} was not found", orderItemRequestDto.productId());
                    return new EntityNotFoundException(PRODUCT, orderItemRequestDto.productId());
                });
    }

    private Order findOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Order with id {} was not found", id);
                    return new EntityNotFoundException(ORDER, id);
                });
    }
}