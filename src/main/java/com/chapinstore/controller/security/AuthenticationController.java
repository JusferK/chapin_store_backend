package com.chapinstore.controller.security;

import com.chapinstore.dto.authentication.request.LoginRequest;
import com.chapinstore.dto.authentication.response.AuthenticationResponse;
import com.chapinstore.service.security.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse<?>> login(
            @Valid @RequestBody LoginRequest loginRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authenticationService.login(loginRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Boolean>> logout(HttpServletRequest request) {
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authenticationService.logout(request));
    }

}
