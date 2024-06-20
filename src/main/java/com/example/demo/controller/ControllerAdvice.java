package com.example.demo.controller;

import com.example.demo.dto.exception.MultiExceptionBody;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.ErrorMessages;
import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.exception.ResourceAlreadyExistsException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleEntityNotFound(EntityNotFoundException e){
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleResourceAlreadyExists(ResourceAlreadyExistsException e){
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleIllegalState(IllegalStateException e){
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MultiExceptionBody handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        MultiExceptionBody multiExceptionBody = new MultiExceptionBody(ErrorMessages.VALIDATION_FAILED_MESSAGE);
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        multiExceptionBody.setErrors(errors.stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
        return multiExceptionBody;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MultiExceptionBody handleConstraintViolation(ConstraintViolationException e){
        MultiExceptionBody multiExceptionBody = new MultiExceptionBody(ErrorMessages.VALIDATION_FAILED_MESSAGE);
        multiExceptionBody.setErrors(e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        violation -> violation.getMessage()
                )));
        return multiExceptionBody;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleException(Exception e){
        return new ExceptionBody(ErrorMessages.INTERNAL_ERROR_MESSAGE);
    }
}
