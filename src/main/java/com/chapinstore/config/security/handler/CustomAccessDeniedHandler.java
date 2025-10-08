package com.chapinstore.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {


    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {

        Map<String, Object> body = Map.of(
                "backendMessage", accessDeniedException.getLocalizedMessage(),
                "url", request.getRequestURI(),
                "method", request.getMethod(),
                "message", "Acceso denegado. No tienes los permisos necesarios para acceder a esta funcion. ",
                "timestamp", LocalDateTime.now().toString()
        );

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        response.getWriter().write(mapper.writeValueAsString(body));
    }
}
