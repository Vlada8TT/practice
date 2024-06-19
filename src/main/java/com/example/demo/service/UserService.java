package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.persistence.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto user);

    UserResponseDto getUserById(int id);

    User getUserByEmail(String email);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(int id, UserRequestDto user);

    UserResponseDto setRole(String roleName, int userId);

    void deleteUser(int id);
}