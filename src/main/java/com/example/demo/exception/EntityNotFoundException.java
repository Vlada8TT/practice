package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName, Integer id){
        super(String.format(ErrorMessages.ENTITY_NOT_FOUND_MESSAGE, entityName, id));
    }

    public EntityNotFoundException(String entityName){
        super(String.format(ErrorMessages.ENTITY_RESOURCE_MISSING_MESSAGE, entityName));
    }
}