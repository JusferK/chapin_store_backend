package com.chapinstore.controller.security;

import com.chapinstore.dto.security.module.request.ModuleCreationRequestDto;
import com.chapinstore.dto.security.module.request.ModulePatchRequestDto;
import com.chapinstore.entity.security.Module;
import com.chapinstore.service.security.ModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Module>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(moduleService.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Module> create(
            @Valid @RequestBody ModuleCreationRequestDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(moduleService.create(request));
    }

    @PatchMapping("/patch")
    public ResponseEntity<ModulePatchRequestDto> patch(
            @Valid @RequestBody ModulePatchRequestDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(moduleService.update(request));
    }

    @DeleteMapping("/disable")
    public ResponseEntity<Map<String, Boolean>> disable(
            @RequestParam Long id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(moduleService.disable(id));
    }

}
