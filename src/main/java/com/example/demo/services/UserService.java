package com.example.demo.services;

import com.example.demo.dto.requests.UserRequestDto;
import com.example.demo.dto.responses.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto user);
    UserResponseDto getUserById(int id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(int id, UserRequestDto user);
    void deleteUser(int id);
}



