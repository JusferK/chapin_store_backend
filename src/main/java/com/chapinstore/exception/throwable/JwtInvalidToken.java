package com.chapinstore.exception.throwable;

public class JwtInvalidToken extends RuntimeException {
    public JwtInvalidToken(String message) {
        super(message);
    }
}
