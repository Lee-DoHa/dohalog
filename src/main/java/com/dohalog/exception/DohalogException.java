package com.dohalog.exception;

public abstract class DohalogException extends RuntimeException{


    public DohalogException(String message) {
        super(message);
    }

    public DohalogException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();
}
