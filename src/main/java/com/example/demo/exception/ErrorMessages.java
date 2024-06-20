package com.example.demo.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessages {
    public static final String ENTITY_NOT_FOUND_MESSAGE = "The %s with id %d not found";
    public static final String RESOURCE_ALREADY_EXIST_MESSAGE = "The %s with %s already exist";
    public static final String INTERNAL_ERROR_MESSAGE = "Internal error";
    public static final String VALIDATION_FAILED_MESSAGE = "Validation failed";
}
