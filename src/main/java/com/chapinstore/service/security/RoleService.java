package com.chapinstore.service.security;

import com.chapinstore.entity.security.Role;
import com.chapinstore.repository.security.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role CustomerRole(String role) {
        return roleRepository.findByName(role)
                .orElseThrow(() -> new EntityNotFoundException("Role no existe"));
    }

}
