package com.chapinstore.exception.throwable;

public class LogoutMissingTokenException extends RuntimeException {
    public LogoutMissingTokenException(String message) {
        super(message);
    }
}
