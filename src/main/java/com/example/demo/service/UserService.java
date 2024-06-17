package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto user);

    UserResponseDto getUserById(int id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(int id, UserRequestDto user);

    void deleteUser(int id);
}