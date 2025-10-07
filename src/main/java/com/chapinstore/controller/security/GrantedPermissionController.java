package com.chapinstore.controller.security;

import com.chapinstore.dto.security.granted_permission.GrantedPermissionWrapperDto;
import com.chapinstore.entity.security.GrantedPermission;
import com.chapinstore.service.security.GrantedPermissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permission")
public class GrantedPermissionController {

    @Autowired
    private GrantedPermissionService grantedPermissionService;

    @PostMapping("/new")
    public ResponseEntity<List<GrantedPermission>> create(
            @Valid @RequestBody GrantedPermissionWrapperDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(grantedPermissionService.create(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> delete(
            @RequestParam Long id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(grantedPermissionService.delete(id));
    }

}