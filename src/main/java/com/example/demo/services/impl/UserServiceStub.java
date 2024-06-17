package com.example.demo.services.impl;

import com.example.demo.dto.requests.UserRequestDto;
import com.example.demo.dto.responses.UserResponseDto;
import com.example.demo.persistence.entity.User;
import com.example.demo.services.UserService;

import java.util.List;

public class UserServiceStub implements UserService {
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
