package com.chapinstore.controller;

import com.chapinstore.dto.administrator.request.AdministratorCreationDto;
import com.chapinstore.dto.authentication.response.AuthenticationResponse;
import com.chapinstore.entity.Administrator;
import com.chapinstore.service.AdministratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/get")
    public ResponseEntity<Administrator> getAdministrator(@RequestParam("username") String username) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(administratorService.find(username));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Administrator>> getAllAdministrator() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(administratorService.getAll());
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse<Administrator>> register(
            @Valid @RequestBody AdministratorCreationDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(administratorService.register(request));

    }

    @PatchMapping("/patch/password")
    public ResponseEntity<Map<String, Boolean>> updatePassword(
            @RequestParam String username,
            @RequestBody Map<String, String> request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(administratorService.updatePassword(username, request));
    }

    @DeleteMapping("/disable")
    public ResponseEntity<Map<String, Boolean>> disable(@RequestParam String username) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(administratorService.disable(username));
    }



}
