package com.chapinstore.controller;

import com.chapinstore.dto.detail.request.DetailUpdateRequestDto;
import com.chapinstore.service.DetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @PatchMapping("/update/quantity")
    public ResponseEntity<Map<String, Boolean>> update(
            @Valid @RequestBody DetailUpdateRequestDto request,
            @RequestParam Integer orderRequestId
    ) {
        return ResponseEntity
                .ok(detailService.update(request,orderRequestId));
    }

}
