package com.example.demo.exception;

public class ResourceNotSetException extends RuntimeException{

    public ResourceNotSetException(String resourceName){
        super(String.format(ErrorMessages.RESOURCE_NOT_SET_MESSAGE, resourceName));
    }

}