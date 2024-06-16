package com.example.demo.services.impl;

import com.example.demo.persistence.entity.User;
import com.example.demo.services.UserService;

import java.util.List;

public class UserServiceStub implements UserService {
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(int id, User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
