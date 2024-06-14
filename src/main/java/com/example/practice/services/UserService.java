package com.example.practice.services;

import com.example.practice.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserService {
    User createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateUser(int id, User user);
    void deleteUser(int id);
}



