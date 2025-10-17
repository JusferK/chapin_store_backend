package com.chapinstore.config.security.filter;

import com.chapinstore.entity.Administrator;
import com.chapinstore.entity.Customer;
import com.chapinstore.entity.security.JwtToken;
import com.chapinstore.entity.security.Operation;
import com.chapinstore.exception.throwable.DisableCredentialsException;
import com.chapinstore.service.AdministratorService;
import com.chapinstore.service.CustomerService;
import com.chapinstore.service.security.JwtService;
import com.chapinstore.service.security.JwtTokenService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = jwtService.extractJwtFromRequest(request);

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Optional<JwtToken> tokenFromBlacklist = jwtTokenService.getToken(token);
        if (tokenFromBlacklist.isPresent() && !tokenFromBlacklist.get().getValid()) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String username = jwtService.extractUsername(token);
            UserDetails user = findUser(username);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetails(request));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            resolver.resolveException(request, response, null, exception);
        }

    }

    private UserDetails findUser(String username) {
        return Optional.ofNullable(customerService.findNullable(username))
                .map(UserDetails.class::cast)
                .or(
                        () -> {

                            Administrator administrator = administratorService.findNullable(username);

                            if (administrator == null) return Optional.empty();
                            if (!administrator.isIsActive()) throw new DisableCredentialsException("El usuario " + administrator.getUsername() + " se encuentra desactivado.");

                            return Optional.ofNullable(administratorService.findNullable(username))
                                    .map(UserDetails.class::cast);
                        }
                )
                .orElseThrow(() -> new EntityNotFoundException("Credenciales inválidas"));
    }

}