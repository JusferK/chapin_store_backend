package com.chapinstore.service;

import com.chapinstore.common.mapper.OrderRequestMapper;
import com.chapinstore.dto.order_request.request.OrderRequestCreationDto;
import com.chapinstore.dto.order_request.request.OrderRequestUpdateDto;
import com.chapinstore.dto.order_request.response.OrderRequestCreationResponseDto;
import com.chapinstore.dto.order_request.response.OrderRequestRetrieveDto;
import com.chapinstore.entity.OrderRequest;
import com.chapinstore.enums.Status;
import com.chapinstore.model.Pagination;
import com.chapinstore.repository.OrderRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderRequestService {

    @Value("${application.order-request.property}")
    private String property;

    @Value("${application.order-request.page-size}")
    private int pageSize;

    @Autowired
    private DetailService detailService;

    @Autowired
    private OrderRequestRepository orderRequestRepository;

    @Autowired
    private OrderRequestMapper orderRequestMapper;

    public Pagination<OrderRequestRetrieveDto> getAll(Integer page) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.ASC, property);
        Page<OrderRequest> orderRequests = orderRequestRepository.findAll(pageable);

        List<OrderRequestRetrieveDto> content = mapList(orderRequests.getContent());

        return Pagination.<OrderRequestRetrieveDto>
                builder()
                .page(page)
                .totalElements((int) orderRequests.getTotalElements())
                .content(content)
                .size(orderRequests.getSize())
                .totalPages(orderRequests.getTotalPages())
                .build();
    }

    public List<OrderRequestRetrieveDto> find(String argument) {
        Date parseDate = parseDate(argument);

        if (parseDate != null) {
            List<OrderRequest> orderRequest = orderRequestRepository
                    .findByEstimatedDeliveryDate(parseDate);

            return mapList(orderRequest);
        }

        List<OrderRequest> orderRequest = orderRequestRepository.findByCustomerEmail(argument);

        return mapList(orderRequest);
    }

    public OrderRequest findById(Integer id) {
        return orderRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la orden"));
    }

    public OrderRequestCreationResponseDto create(OrderRequestCreationDto orderRequestCreationDto) {
        OrderRequest orderRequest = orderRequestMapper.toOrderRequest(orderRequestCreationDto);
        orderRequest = orderRequestRepository.save(orderRequest);

        detailService.create(
                orderRequestCreationDto.getOrderDetail(),
                orderRequest.getOrderRequestId()
        );

        return orderRequestMapper.toOrderRequestCreationResponseDto(orderRequest);
    }

    public OrderRequestUpdateDto update(OrderRequestUpdateDto orderRequestUpdateDto) {

        OrderRequest findOrder = orderRequestRepository.findById(orderRequestUpdateDto.getOrderRequestId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontro ninguna orden"));

        mapAndUpdate(orderRequestUpdateDto, findOrder);

        return orderRequestUpdateDto;
    }

    public Map<String, String> updateStatus(Status status, Integer orderRequestId) {

        OrderRequest findOrder = orderRequestRepository.findById(orderRequestId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro ninguna orden"));

        checkStatusAndSave(findOrder, status);

        return Map.of("status", status.toString());
    }

    public Map<String, Boolean> delete(Integer orderRequestId) {

        OrderRequest findOrder = orderRequestRepository.findById(orderRequestId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro ninguna orden"));

        orderRequestRepository.delete(findOrder);
        return Map.of("deleted", Boolean.TRUE);
    }

    private Date parseDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(date, formatter);
            return java.sql.Date.valueOf(localDate);
        } catch (Exception e) {
            return null;
        }
    }

    private List<OrderRequestRetrieveDto> mapList(List<OrderRequest> orderRequests) {
        return orderRequests
                .stream()
                .map(this::toOrderRequestRetrieveDto)
                .toList();
    }

    private OrderRequestRetrieveDto toOrderRequestRetrieveDto(OrderRequest orderRequest) {
        return orderRequestMapper.toOrderRequestRetrieveDto(orderRequest);
    }

    private void mapAndUpdate(OrderRequestUpdateDto orderDto, OrderRequest orderRequest) {

        if (orderDto.getShippingAddress() != null) orderRequest.setShippingAddress(orderDto.getShippingAddress());
        if (orderDto.getPaymentId() != null) orderRequest.setPaymentId(orderDto.getPaymentId());

        orderRequestRepository.save(orderRequest);
    }

    private void checkStatusAndSave(OrderRequest order, Status settingStatus) {
        switch (order.getStatus()) {
            case CANCELLED -> throw new IllegalArgumentException("La orden se encuentra cancelada");
            case DELIVERED -> throw new IllegalArgumentException("La orden se encuentra entregada");
            default -> {
                if (order.getStatus().toString().equals(settingStatus.toString()))
                    throw new IllegalArgumentException("No puede ser el mismo estado");

                order.setStatus(settingStatus);
                orderRequestRepository.save(order);
            }
        }

    }

}