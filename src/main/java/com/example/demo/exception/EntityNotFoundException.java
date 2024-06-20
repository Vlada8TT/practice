package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName, Integer id){
        super(String.format(ErrorMessages.stringIntegerMessageNotFound, entityName, id));
    }

    public EntityNotFoundException(String entityName, String email){
        super(String.format(ErrorMessages.stringStringMessageNotFound, entityName, email));
    }

}