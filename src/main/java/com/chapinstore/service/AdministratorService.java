package com.chapinstore.service;

import com.chapinstore.dto.administrator.request.AdministratorCreationDto;
import com.chapinstore.entity.Administrator;
import com.chapinstore.repository.AdministratorRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public Map<String, ?> register(AdministratorCreationDto request) {

        administratorRepository.findByUsername(request.getUsername())
                .ifPresent(administrator -> {
                    throw new EntityExistsException("Administrador con este usuario ya existe");
                });

        Administrator administrator = new Administrator(request.getUsername(), request.getPassword());
        administratorRepository.save(administrator);

        return Map.of(
                "created", true,
                "administrator", administrator.getUsername()
        );
    }

    public List<Administrator> getAll() {
        return administratorRepository.findAll();
    }

    public Administrator find(String username) {
        return administratorRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Administrator no encontrado"));
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
        administrator.setEnabled(false);
        administratorRepository.save(administrator);
        return Map.of("disable", true);
    }

}
