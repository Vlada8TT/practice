package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName, Integer id){
        super(String.format(ErrorMessages.stringIntegerMessage, entityName, id));
    }

    public EntityNotFoundException(String entityName, String email){
        super(String.format(ErrorMessages.stringStringMessage, entityName, email));
    }

}