package com.chapinstore.service;

import com.chapinstore.dto.administrator.request.AdministratorCreationDto;
import com.chapinstore.dto.authentication.response.AuthenticationResponse;
import com.chapinstore.entity.Administrator;
import com.chapinstore.repository.AdministratorRepository;
import com.chapinstore.service.security.JwtService;
import com.chapinstore.service.security.RoleService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RoleService roleService;

    public AuthenticationResponse<Administrator> register(AdministratorCreationDto request) {

        administratorRepository.findByUsername(request.getUsername())
                .ifPresent(administrator -> {
                    throw new EntityExistsException("Administrador con este usuario ya existe");
                });

        Administrator administrator = new Administrator(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword())
        );
        administrator.setRole(roleService.CustomerRole(request.getRole()));
        Administrator adminSaved = administratorRepository.save(administrator);

        String jwt = jwtService.generate(adminSaved, generateClaims(adminSaved));

        return new AuthenticationResponse<>(jwt, adminSaved);
    }

    public List<Administrator> getAll() {
        return administratorRepository.findAll();
    }

    public Administrator find(String username) {
        return administratorRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Administrator no encontrado"));
    }

    public Administrator findNullable(String username) {
        return administratorRepository
                .findByUsername(username)
                .orElse(null);
    }

    public Map<String, Boolean> updatePassword(String username, Map<String, String> request) {

        String password = request.get("password");
        if (password == null) throw new IllegalArgumentException("password requerido");

        Administrator administrator = find(username);
        administrator.setPassword(password);
        administratorRepository.save(administrator);

        return Map.of("updated", true);
    }

    public Map<String, Boolean> disable(String username) {
        Administrator administrator = find(username);
        administrator.setIsActive(false);
        administratorRepository.save(administrator);
        return Map.of("disable", true);
    }

    private Map<String, Object> generateClaims(Administrator administrator) {
        return Map.of(
                "name", administrator.getUsername(),
                "role", administrator.getRole().getName(),
                "authorities", administrator.getAuthorities()
        );
    }

}
