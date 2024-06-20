package com.example.demo.service.impl;

import com.example.demo.dto.auth.JwtRequest;
import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
