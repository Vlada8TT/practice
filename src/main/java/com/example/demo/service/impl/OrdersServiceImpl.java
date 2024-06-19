package com.example.demo.service.impl;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.User;
import com.example.demo.persistence.enums.OrderStatus;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

        Order order = orderMapper.toEntity(orderRequestDto);
        User user = userRepository.findById(orderRequestDto.userId())
                .orElseThrow(() -> new EntityNotFoundException("user",orderRequestDto.userId()));
        order.setUser(user);
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDto getOrderById(int id) {

        return orderMapper.toDto(orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponseDto> getAllOrders() {

        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    @Transactional
    public OrderResponseDto updateOrder(int id, OrderRequestDto orderRequestDto) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order",id));
        updateOrderFields(order,orderRequestDto);
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order", id));
        orderRepository.delete(order);
    }

    private void updateOrderFields(Order order, OrderRequestDto orderRequestDto){

        User user = userRepository.findById(orderRequestDto.userId())
                .orElseThrow(() -> new EntityNotFoundException("user",orderRequestDto.userId()));
        order.setUser(user);
        order.setOrderDate(orderRequestDto.time());
        order.setStatus(OrderStatus.valueOf(orderRequestDto.status()));
    }
}