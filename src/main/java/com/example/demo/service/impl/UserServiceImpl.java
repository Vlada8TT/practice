package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.persistence.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
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
        return null;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }
}