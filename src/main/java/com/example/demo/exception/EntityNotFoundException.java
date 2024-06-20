package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName, Integer id){
        super(String.format(ErrorMessages.ENTITY_NOT_FOUND_BY_ID_MESSAGE, entityName, id));
    }

    public EntityNotFoundException(String entityName, String email){
        super(String.format(ErrorMessages.ENTITY_NOT_FOUND_BY_INFO_MESSAGE, entityName, email));
    }

}