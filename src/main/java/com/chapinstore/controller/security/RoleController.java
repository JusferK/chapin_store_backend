package com.chapinstore.controller.security;

import com.chapinstore.dto.security.role.request.CreateRoleRequest;
import com.chapinstore.entity.security.Role;
import com.chapinstore.service.security.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/new")
    public ResponseEntity<Role> create(
            @Valid @RequestBody CreateRoleRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleService.create(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleService.findAll());
    }

    @DeleteMapping("/disable")
    public ResponseEntity<Map<String, Boolean>> disable(
            @RequestParam String role
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleService.disableRole(role));
    }

}
