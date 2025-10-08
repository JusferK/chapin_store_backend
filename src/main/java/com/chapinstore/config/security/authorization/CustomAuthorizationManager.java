package com.chapinstore.config.security.authorization;

import com.chapinstore.entity.Administrator;
import com.chapinstore.entity.Customer;
import com.chapinstore.entity.security.GrantedPermission;
import com.chapinstore.entity.security.Operation;
import com.chapinstore.service.AdministratorService;
import com.chapinstore.service.CustomerService;
import com.chapinstore.service.security.OperationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Autowired
    private OperationService operationService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private CustomerService customerService;

    @Override
    public AuthorizationDecision check(
            Supplier<Authentication> authentication,
            RequestAuthorizationContext request
    ) {

        HttpServletRequest httpRequest = request.getRequest();
        String url = extractUrl(httpRequest);
        String method = httpRequest.getMethod();

        boolean isPublic = isPublic(url, method);

        if (isPublic) return new AuthorizationDecision(true);

        boolean isGranted = isGranted(url, method, authentication.get());

        return new AuthorizationDecision(isGranted);
    }

    private String extractUrl(HttpServletRequest httpRequest) {
        String contextPath = httpRequest.getContextPath();
        String url = httpRequest.getRequestURI();
        return url.replaceAll(contextPath, "");
    }

    private boolean isPublic(String url, String method) {
        return operationService.findByPublic()
                .stream()
                .anyMatch(operation -> getOperationPredicate(url, method, operation));
    }

    private static boolean getOperationPredicate(String url, String method, Operation operation) {
        String basePath = operation
                .getModule()
                .getBasePath();

        Pattern pattern = Pattern
                .compile(basePath.concat(operation.getPath()));

        Matcher matcher = pattern.matcher(url);

        return matcher.matches() && operation.getMethod().equals(method);
    }

    private boolean isGranted(String url, String method, Authentication authentication) {

        if (authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken))
            throw new AuthenticationCredentialsNotFoundException("Usuario no ha iniciado sesion.");


        List<Operation> operations = obtainedOperations(authentication);

        return operations
                .stream()
                .anyMatch(operation -> getOperationPredicate(url, method, operation));

    }

    private List<Operation> obtainedOperations(Authentication authentication) {

        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
        String username = (String) authToken.getPrincipal();

        Administrator findAdmin = administratorService.findNullable(username);
        Customer findCustomer = customerService.findNullable(username);

        if (findCustomer != null) return findCustomer.
                getRole()
                .getPermissions()
                .stream()
                .map(GrantedPermission::getOperation)
                .toList();

        if (findAdmin != null) return findAdmin
                .getRole()
                .getPermissions()
                .stream()
                .map(GrantedPermission::getOperation)
                .toList();

        throw new EntityNotFoundException("No se encontraron credenciales");
    }


}
