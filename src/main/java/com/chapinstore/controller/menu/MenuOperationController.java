package com.chapinstore.controller.menu;

import com.chapinstore.dto.menu.request.MenuOperationCreationDto;
import com.chapinstore.dto.menu.request.MenuOperationPatchDto;
import com.chapinstore.entity.menu.MenuOperation;
import com.chapinstore.service.menu.MenuOperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuOperationController {

    @Autowired
    private MenuOperationService menuOperationService;

    @PostMapping("/new")
    public ResponseEntity<MenuOperation> create(
            @Valid @RequestBody MenuOperationCreationDto menuOperation
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(menuOperationService.create(menuOperation));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MenuOperation>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuOperationService.findAll());
    }

    @GetMapping("/get-by-role")
    public ResponseEntity<List<MenuOperation>> getByRole(
            @RequestParam String username
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuOperationService.findByRole(username));
    }

    @PatchMapping("/patch")
    public ResponseEntity<MenuOperationPatchDto> patch(
            @Valid @RequestBody MenuOperationPatchDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuOperationService.patch(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> delete(
            @RequestParam Long menuId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuOperationService.delete(menuId));
    }

}
