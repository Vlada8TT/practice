package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String entityName, Integer id) {
        super(String.format("The %s with id %d not found", entityName, id));
    }
    public EntityNotFoundException(String entityName, String email) {
        super(String.format("The %s with id %s not found", entityName, email));
    }
}
