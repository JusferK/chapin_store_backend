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

    @GetMapping("/get")
    public ResponseEntity<List<OrderRequestRetrieveDto>> get(
            @RequestParam String argument
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.find(argument));
    }

    @PostMapping("/new")
    public ResponseEntity<OrderRequestCreationResponseDto> create(
            @Valid @RequestBody OrderRequestCreationDto orderRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderRequestService.create(orderRequest));
    }

    @PatchMapping("/update")
    public ResponseEntity<OrderRequestUpdateDto> update(
            @Valid @RequestBody OrderRequestUpdateDto orderRequestUpdateDto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.update(orderRequestUpdateDto));
    }

    @PatchMapping("/update/status")
    public ResponseEntity<Map<String, String>> updateStatus(
            @RequestParam Status status,
            @RequestParam Integer orderRequestId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.updateStatus(status, orderRequestId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> delete(
            @RequestParam Integer orderRequestId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderRequestService.delete(orderRequestId));
    }

}
