package com.example.practice.services;

import com.example.practice.persistence.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateUser(int id, User user);
    void deleteUser(int id);
}



