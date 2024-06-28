package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.persistence.entity.Order;
import com.example.demo.persistence.entity.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.ExceptionSourceName.ORDER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto user) {
        return null;
    }

    @Override
    public UserResponseDto getUserById(int id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return null;
    }

    @Override
    public UserResponseDto updateUser(int id, UserRequestDto user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean isOrderOwner(int userId, int orderId) {
        return findOrderById(orderId).getUser().getId().equals(userId);
    }

    private Order findOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ORDER, id));
    }
}