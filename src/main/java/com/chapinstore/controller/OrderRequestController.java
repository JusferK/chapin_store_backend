package com.chapinstore.controller;

import com.chapinstore.dto.order_request.request.OrderRequestCreationDto;
import com.chapinstore.dto.order_request.request.OrderRequestUpdateDto;
import com.chapinstore.dto.order_request.response.OrderRequestCreationResponseDto;
import com.chapinstore.dto.order_request.response.OrderRequestRetrieveDto;
import com.chapinstore.enums.Status;
import com.chapinstore.model.Pagination;
import com.chapinstore.service.OrderRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order-request")
public class OrderRequestController {

    @Autowired
    private OrderRequestService orderRequestService;

    @GetMapping("/get-all")
    public ResponseEntity<Pagination<OrderRequestRetrieveDto>> getAll(
        @RequestParam(defaultValue = "0", required = false) Integer page
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.getAll(page));
    }

    @PostMapping("/get")
    public ResponseEntity<List<OrderRequestRetrieveDto>> get(
            @RequestBody Map<String, ?> request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.find(request));
    }

    @PostMapping("/new")
    public ResponseEntity<OrderRequestCreationResponseDto> create(
            @Valid @RequestBody OrderRequestCreationDto orderRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderRequestService.create(orderRequest));
    }

    @PatchMapping("/patch")
    public ResponseEntity<OrderRequestUpdateDto> update(
            @Valid @RequestBody OrderRequestUpdateDto orderRequestUpdateDto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.update(orderRequestUpdateDto));
    }

    @PatchMapping("/update/status")
    public ResponseEntity<Map<String, String>> updateStatus(
            @RequestBody Map<String, ?> request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.updateStatus(request));
    }

}
