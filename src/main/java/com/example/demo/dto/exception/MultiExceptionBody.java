package com.example.demo.dto.exception;

import lombok.Builder;

import java.util.Map;

@Builder
public record MultiExceptionBody(
        Integer status,
        String message,
        Map<String, String> errors) {

}
