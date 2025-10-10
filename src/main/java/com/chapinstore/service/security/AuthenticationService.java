package com.chapinstore.service.security;

import com.chapinstore.dto.authentication.request.LoginRequest;
import com.chapinstore.dto.authentication.response.AuthenticationResponse;
import com.chapinstore.entity.Administrator;
import com.chapinstore.entity.Customer;
import com.chapinstore.entity.security.JwtToken;
import com.chapinstore.exception.throwable.LogoutMissingTokenException;
import com.chapinstore.service.AdministratorService;
import com.chapinstore.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private JwtTokenService jwtTokenService;

    public AuthenticationResponse<?> login(LoginRequest request) {

        Authentication authenticateUser = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );

        authenticationManager.authenticate(authenticateUser);

        return findEntity(request.getUsername());
    }

    public Map<String, Boolean> logout(HttpServletRequest request) {

        String token = jwtService.extractJwtFromRequest(request);
        if (token == null) throw new LogoutMissingTokenException("El token es requerido para salir de la sesion.");

        Optional<JwtToken> findToken = jwtTokenService.getToken(token);
        if (findToken.isEmpty()) jwtTokenService.saveToken(token);

        return Map.of("logout", Boolean.TRUE);
    }

    public Map<String, Boolean> validate(HttpServletRequest request) {

        String token = jwtService.extractJwtFromRequest(request);
        jwtService.extractUsername(token);

        return Map.of("valid", true);
    }

    private AuthenticationResponse<?> findEntity(String username) {

        Customer findCustomer = customerService.findNullable(username);
        String jwt;

        if (findCustomer != null) {
            jwt = jwtService.generate(findCustomer, generateClaims(findCustomer));;
            return new AuthenticationResponse<>(jwt, findCustomer);
        }

        Administrator findAdmin = administratorService.findNullable(username);
        jwt = jwtService.generate(findAdmin, generateClaims(findAdmin));

        return new AuthenticationResponse<>(jwt, findAdmin);
    }

    private Map<String, Object> generateClaims(Object user) {

        Map<String, Object> claims;

        if (user instanceof Customer customer) {
            claims = Map.of(
                    "name", customer.getName() + " " + customer.getLastName(),
                    "role", customer.getRole().getName(),
                    "authorities", customer.getAuthorities()
            );

            return claims;
        }

        Administrator administrator = (Administrator) user;
        claims = Map.of(
                "name", administrator.getUsername(),
                "role", administrator.getRole().getName(),
                "authorities", administrator.getAuthorities()
        );

        return claims;
    }



}
