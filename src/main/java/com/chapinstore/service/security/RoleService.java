package com.chapinstore.service.security;

import com.chapinstore.dto.security.role.request.CreateRoleRequest;
import com.chapinstore.entity.security.Role;
import com.chapinstore.repository.security.RoleRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role CustomerRole(String role) {
        return roleRepository.findByName(role)
                .orElseThrow(() -> new EntityNotFoundException("Role no existe"));
    }

    public Role create(CreateRoleRequest request) {

        roleRepository.findByName(request.getName())
                .ifPresent(role -> {
                    throw new EntityExistsException("El rol ya existe.");
                });

        return roleRepository.save(
                new Role(request.getName().toUpperCase())
        );
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role find(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El rol no fue encontrado."));
    }

    public Map<String, Boolean> disableRole(String role) {

        Role find = roleRepository.findByName(role)
                .orElseThrow(() -> new EntityNotFoundException("El rol no existe."));

        find.setActive(false);
        roleRepository.save(find);
        return Map.of("disable", Boolean.TRUE);
    }

}
