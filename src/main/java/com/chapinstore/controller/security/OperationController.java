package com.chapinstore.controller.security;

import com.chapinstore.dto.security.operation.request.OperationCreationWrapperDto;
import com.chapinstore.dto.security.operation.request.OperationPatchRequestDto;
import com.chapinstore.entity.security.Operation;
import com.chapinstore.service.security.OperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("/new")
    public ResponseEntity<List<Operation>> create(
            @Valid @RequestBody OperationCreationWrapperDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(operationService.create(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Operation>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(operationService.findAll());
    }

    @PatchMapping("/patch")
    public ResponseEntity<OperationPatchRequestDto> patch(
            @Valid @RequestBody OperationPatchRequestDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(operationService.patch(request));
    }

    @DeleteMapping("/disable")
    public ResponseEntity<Map<String, Boolean>> disable(
            @RequestParam Long id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(operationService.disable(id));
    }


}
