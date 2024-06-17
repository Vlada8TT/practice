package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.service.UserService;
import java.util.List;

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
}
