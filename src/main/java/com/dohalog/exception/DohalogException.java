package com.dohalog.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class DohalogException extends RuntimeException{

    public final Map<String, String> validation = new HashMap<>();

    public DohalogException(String message) {
        super(message);
    }

    public DohalogException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }
}
