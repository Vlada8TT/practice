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

import static com.example.demo.util.ExceptionSourceName.USER;
import static com.example.demo.util.ExceptionSourceName.ORDER;
import static com.example.demo.util.ExceptionSourceName.ADDRESS;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        if (!userRepository.isAddressSet(orderRequestDto.userId())) {
            throw new EntityNotFoundException(ADDRESS);
        }
        Order order = orderMapper.toEntity(orderRequestDto);
        order.setUser(findUserById(orderRequestDto));
        order.setStatus(OrderStatus.valueOf(orderRequestDto.status()));
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDto getOrderById(int id) {
        return orderMapper.toDto(findOrderById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponseDto> getAllOrders() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    @Transactional
    public OrderResponseDto updateOrder(int id, OrderRequestDto orderRequestDto) {
        Order order = findOrderById(id);
        orderMapper.updateOrderFromDto(orderRequestDto,order);
        order.setUser(findUserById(orderRequestDto));
        order.setStatus(OrderStatus.valueOf(orderRequestDto.status()));
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        Order order = findOrderById(id);
        orderRepository.delete(order);
    }

    private Order findOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ORDER, id));
    }

    private User findUserById(OrderRequestDto orderRequestDto) {
        return userRepository.findById(orderRequestDto.userId())
                .orElseThrow(() -> new EntityNotFoundException(USER,orderRequestDto.userId()));
    }
}