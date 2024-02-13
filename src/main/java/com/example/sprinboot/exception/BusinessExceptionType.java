package com.example.sprinboot.exception;

public enum BusinessExceptionType {
    RECORD_NOT_FOUND (1000,"Record Not Found"),
    BAD_REQUEST(1001, "Bad Request");

    private final int code;
    private final String message;

    BusinessExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
