package com.example.demo.controller;

import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.security.exception.AccessDeniedException;
import io.jsonwebtoken.JwtException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionBody handleAccessDenied() {
        return ExceptionBody.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message("Access denied")
                .build();
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionBody handleUnauthorized() {
        return ExceptionBody.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .message("Unauthorized")
                .build();
    }

    @ExceptionHandler(JwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionBody handleJwtException() {
        return ExceptionBody.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Invalid JWT token format")
                .build();
    }

}
