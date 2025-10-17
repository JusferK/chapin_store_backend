package com.chapinstore.exception;

import com.chapinstore.exception.throwable.*;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
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

    @ExceptionHandler(AddressCreationException.class)
    public ResponseEntity<Map<String, Object>> handleAddressCreationException(AddressCreationException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.NOT_ACCEPTABLE.value(),
                "error", "Cannot add more addresses",
                "message", ex.getLocalizedMessage()
        );

        return  ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.NOT_ACCEPTABLE.value(),
                "error", "Request not acceptable",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .body(body);

    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, Object>> handleAuthenticationException(AuthenticationException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.UNAUTHORIZED.value(),
                "message", "Las credenciales ingresadas son incorrectas.",
                "error", ex.getLocalizedMessage()
        );

        return  ResponseEntity
                .status(HttpStatus.UNAUTHORIZED.value())
                .body(body);
    }

    @ExceptionHandler(LogoutMissingTokenException.class)
    public ResponseEntity<Map<String, Object>> handleLogoutTokenMissingException(LogoutMissingTokenException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.CONFLICT.value(),
                "message", "Token missing",
                "error", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT.value())
                .body(body);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, Object>> handleExpiredJwtException(ExpiredJwtException ex, HttpServletRequest request) {

        Map<String, Object> body = Map.of(
                "backendMessage", ex.getLocalizedMessage(),
                "url", request.getRequestURI(),
                "method", request.getMethod(),
                "message", "Las credenciales han expirado, inicie sesion de nuevo por favor.",
                "timestamp", LocalDateTime.now().toString()
        );


        return  ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(body);
    }

    @ExceptionHandler(DisableCredentialsException.class)
    public  ResponseEntity<Map<String, Object>> handleDisableCredentialsException(DisableCredentialsException ex) {

        Map<String, Object> body = Map.of(
                "status", HttpStatus.UNAUTHORIZED.value(),
                "error", "Invalid credentials",
                "message", ex.getLocalizedMessage()
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED.value())
                .body(body);
    }

}