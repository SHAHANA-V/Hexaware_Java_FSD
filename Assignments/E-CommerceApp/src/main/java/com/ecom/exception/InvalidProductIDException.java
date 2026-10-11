package com.ecom.exception;

public class InvalidProductIDException extends RuntimeException {
    public InvalidProductIDException(String message) {
        super(message);
    }
}
