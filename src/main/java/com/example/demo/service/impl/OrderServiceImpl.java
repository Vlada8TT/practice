package com.example.demo.service.impl;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ResourceNotSetException;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.enums.OrderStatus;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.util.ExceptionSourceName.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        log.info("Creating order");
        checkUserAddressIsSet(orderRequestDto);
        Order order = orderMapper.toEntity(orderRequestDto);
        order.setUser(findUserById(orderRequestDto));
        order.setStatus(OrderStatus.NEW);
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDto getOrderById(int id) {
        log.info("Retrieving order by id {}", id);
        return orderMapper.toDto(findOrderById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponseDto> getAllOrders() {
        log.info("Retrieving all orders");
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    @Transactional
    public OrderResponseDto updateOrder(int id, OrderRequestDto orderRequestDto) {
        log.info("Updating order with id {}", id);
        Order order = findOrderById(id);
        orderMapper.updateOrderFromDto(orderRequestDto, order);
        order.setUser(findUserById(orderRequestDto));
        order.setStatus(OrderStatus.valueOf(orderRequestDto.status()));
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        log.info("Deleting order with id {}", id);
        Order order = findOrderById(id);
        orderRepository.delete(order);
    }

    private Order findOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Order with id {} was not found", id);
                    return new EntityNotFoundException(ORDER, id);
                });
    }

    private User findUserById(OrderRequestDto orderRequestDto) {
        return userRepository.findById(orderRequestDto.userId())
                .orElseThrow(() -> {
                    log.error("User with id {} was not found", orderRequestDto.userId());
                    return new EntityNotFoundException(USER, orderRequestDto.userId());
                });
    }

    private boolean isAddressSet(OrderRequestDto orderRequestDto) {
       User user = findUserById(orderRequestDto);
       return user.getAddress() != null;
    }

    private void checkUserAddressIsSet(OrderRequestDto orderRequestDto) {
        log.info("Checking if address is set...");
        if (!isAddressSet(orderRequestDto)) {
            log.error("Address of user with id = {} not set",
                    orderRequestDto.userId(),
                    new ResourceNotSetException(ADDRESS));
            throw new ResourceNotSetException(ADDRESS);
        }
    }
}