package com.example.demo.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessages {
    public static final String ENTITY_NOT_FOUND_BY_ID_MESSAGE = "The %s with %s not found";
    public static final String ENTITY_NOT_FOUND_BY_INFO_MESSAGE = "The %s with %d not found";
    public static final String RESOURCE_ALREADY_EXIST_MESSAGE = "The %s with %s already exist";
    public static final String INTERNAL_ERROR = "Internal error";
    public static final String VALIDATION_FAILED = "Validation failed";
}
