package com.example.demo.security;

import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.security.exception.AccessDeniedException;
import com.example.demo.security.props.JwtProperties;
import com.example.demo.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }

    public String createAccessToken(
            final Integer userId,
            final String email,
            final Role role
    ) {
        Claims claims = Jwts.claims()
                .subject(email)
                .add("id", userId)
                .add("role", role.getName())
                .build();
        Instant validity = Instant.now()
                .plus(jwtProperties.getAccess(), ChronoUnit.HOURS);

        return Jwts.builder()
                .claims(claims)
                .expiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    public String createRefreshToken(
            final Integer userId,
            final String email
    ) {
        Claims claims = Jwts.claims()
                .subject(email)
                .add("id", userId)
                .build();
        Instant validity = Instant.now()
                .plus(jwtProperties.getRefresh(), ChronoUnit.DAYS);
        return Jwts.builder()
                .claims(claims)
                .expiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    public JwtResponse refreshUserTokens(
            final String refreshToken
    ) {
        JwtResponse jwtResponse = new JwtResponse();
        if (!isValid(refreshToken)) {
            throw new AccessDeniedException();
        }

        Integer userId = getId(refreshToken);
        User user = userService.getById(userId);

        jwtResponse.setId(user.getId());
        jwtResponse.setEmail(user.getEmail());
        jwtResponse.setAccessToken(
                createAccessToken(userId, user.getEmail(), user.getRole())
        );
        jwtResponse.setRefreshToken(
                createRefreshToken(userId, user.getEmail())
        );

        return jwtResponse;
    }

    public boolean isValid(
            final String token
    ) {
        Jws<Claims> claims = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
        return claims.getPayload()
                .getExpiration()
                .after(new Date());
    }

    private Integer getId(
            final String token
    ) {
        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("id", Integer.class);
    }

    private String getEmail(
            final String token
    ) {
        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public Authentication getAuthentication(
            final String token
    ) {
        String userEmail = getEmail(token);

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(userEmail);

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                "",
                userDetails.getAuthorities());
    }
}
