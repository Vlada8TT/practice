package com.example.demo.service.impl;

import com.example.demo.dto.auth.JwtRequest;
import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.persistence.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(
            final JwtRequest loginRequest
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(), loginRequest.password())
        );

        User user = userRepository.findByEmail(loginRequest.username()).get();

        return new JwtResponse(
                user.getId(),
                user.getEmail(),
                jwtTokenProvider.createAccessToken(user.getId(), user.getEmail(), user.getRole()),
                jwtTokenProvider.createRefreshToken(user.getId(), user.getEmail())
        );
    }

    @Override
    public JwtResponse refresh(
            final String refreshToken
    ) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
