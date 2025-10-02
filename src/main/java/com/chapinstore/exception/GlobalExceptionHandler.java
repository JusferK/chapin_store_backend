package com.chapinstore.exception;

import com.chapinstore.exception.throwable.InvalidOrderStatusException;
import com.chapinstore.exception.throwable.PaymentSecurityCompromisedException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Set<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> Map.of(
                        "field", fieldError.getField().replaceAll(".*\\.", ""),
                        "message", fieldError.getDefaultMessage()
                ))
                .collect(Collectors.toSet());

        Map<String, Object> body = Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "message", "Request body is not valid.",
                "errors", errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleHttpClientErrorNotFoundException(EntityNotFoundException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.NOT_FOUND.value(),
                "error", "Resource not found",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalAccessException(IllegalAccessException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Conflict while inserting",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Map<String, Object>> handleEntityExistsException(EntityExistsException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.CONFLICT.value(),
                "error", "Conflict while inserting",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }

    @ExceptionHandler(PaymentSecurityCompromisedException.class)
    public ResponseEntity<Map<String, Object>> handlePaymentSecurityCompromisedException(PaymentSecurityCompromisedException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.UNAUTHORIZED.value(),
                "error", "Security compromised",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED.value())
                .body(body);

    }

    @ExceptionHandler(InvalidOrderStatusException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidOrderStatusException(InvalidOrderStatusException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.CONFLICT.value(),
                "error", "Invalid order status",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT.value())
                .body(body);

    }

}