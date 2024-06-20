package com.example.demo.dto.exception;

import lombok.Builder;

@Builder
public record ExceptionBody(

        Integer status,

        String message
) {
}