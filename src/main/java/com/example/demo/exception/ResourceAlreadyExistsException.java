package com.example.demo.exception;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(String entityName, String resource){
        super(String.format(ErrorMessages.RESOURCE_ALREADY_EXIST_MESSAGE, entityName, resource));
    }

}
