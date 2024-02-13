package com.example.sprinboot.exception;

public class BusinessException extends RuntimeException{

    private final BusinessExceptionType type;


    public BusinessExceptionType getType() {
        return type;
    }

    public BusinessException(BusinessExceptionType type, String message){
        super("Code: " + type.getCode() + ": " + message);
        this.type = type;
    }


    public BusinessException(BusinessExceptionType type, String message, Throwable cause){
        super("Code: " + type.getCode() + ": " + message, cause);
        this.type = type;
    }
}
