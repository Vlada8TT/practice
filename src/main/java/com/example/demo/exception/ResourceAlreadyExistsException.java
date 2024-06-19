package com.example.demo.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String entityName, Integer id){
        super(String.format("The %s with id %d not found", entityName, id));
    }
}
