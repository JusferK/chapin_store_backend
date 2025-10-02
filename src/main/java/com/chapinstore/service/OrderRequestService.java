package com.chapinstore.service;

import com.chapinstore.common.mapper.OrderRequestMapper;
import com.chapinstore.dto.detail.response.DetailRetrieveDto;
import com.chapinstore.dto.order_request.request.OrderRequestCreationDto;
import com.chapinstore.dto.order_request.request.OrderRequestUpdateDto;
import com.chapinstore.dto.order_request.response.OrderRequestCreationResponseDto;
import com.chapinstore.dto.order_request.response.OrderRequestRetrieveDto;
import com.chapinstore.dto.payment.response.PaymentRetrieveDtoV2;
import com.chapinstore.dto.product.response.ProductRetrieveDtoResponseV2;
import com.chapinstore.entity.OrderRequest;
import com.chapinstore.entity.Product;
import com.chapinstore.enums.Status;
import com.chapinstore.exception.throwable.InvalidOrderStatusException;
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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

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

        List<OrderRequest> orderRequest = findById(argument);
        if (!orderRequest.isEmpty()) return mapList(orderRequest);

        orderRequest = orderRequestRepository.findByCustomerEmail(argument);
        return mapList(orderRequest);
    }

    public OrderRequest findById(Integer id) {
        return orderRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la orden"));
    }

    public OrderRequestCreationResponseDto create(OrderRequestCreationDto orderRequestCreationDto) {

        OrderRequest orderRequest = orderRequestMapper.toOrderRequest(orderRequestCreationDto);
        Date estimatedDeliveryDate = estimateDeliveryDate(orderRequestCreationDto.getOrderDetail().size());
        orderRequest.setEstimatedDeliveryDate(estimatedDeliveryDate);

        paymentService.isUserPaymentMethodOwner(orderRequest.getCustomerEmail(), orderRequest.getPaymentId());

        Double estimatedTotal = calculateTotal(orderRequest);
        orderRequest.setTotalAmount(estimatedTotal);

        orderRequest.setStatus(Status.PENDING);
        orderRequest.setOrderDetail(List.of());
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
                .map(orderRequest -> {

                    OrderRequestRetrieveDto orderRequestFormatted = orderRequestMapper.toOrderRequestRetrieveDto(orderRequest);
                    PaymentRetrieveDtoV2 paymentData = paymentService.findAndMap(orderRequest.getPaymentId());
                    orderRequestFormatted.setPaymentInfo(paymentData);

                    List<DetailRetrieveDto> formattedDetailList = orderRequest.getOrderDetail()
                            .stream()
                            .map(detail -> {

                                DetailRetrieveDto formattedDetail = detailService.map(detail);

                                if (orderRequest.getOrderDetail().size() > 10) return formattedDetail;

                                ProductRetrieveDtoResponseV2 product = productService.findAndMap(detail.getProductId());
                                formattedDetail.setProductId(null);
                                formattedDetail.setProduct(product);

                                return formattedDetail;
                            })
                            .toList();

                    orderRequestFormatted.setOrderDetail(formattedDetailList);
                    return orderRequestFormatted;
                })
                .toList();
    }

    private void mapAndUpdate(OrderRequestUpdateDto orderDto, OrderRequest orderRequest) {

        if (orderDto.getShippingAddress() != null) orderRequest.setShippingAddress(orderDto.getShippingAddress());

        paymentService.isUserPaymentMethodOwner(orderRequest.getCustomerEmail(), orderDto.getPaymentId());
        if (orderDto.getPaymentId() != null) orderRequest.setPaymentId(orderDto.getPaymentId());

        orderRequestRepository.save(orderRequest);
    }

    private void checkStatusAndSave(OrderRequest order, Status settingStatus) {
        switch (order.getStatus()) {
            case CANCELLED -> throw new InvalidOrderStatusException("La orden se encuentra cancelada");
            case DELIVERED -> throw new InvalidOrderStatusException("La orden se encuentra entregada");
            default -> {
                if (order.getStatus().toString().equals(settingStatus.toString()))
                    throw new InvalidOrderStatusException("No puede ser el mismo estado");

                order.setStatus(settingStatus);
                orderRequestRepository.save(order);
            }
        }

    }

    private List<OrderRequest> findById(String id) {

        try {
            Integer parsedId = Integer.parseInt(id);
            Optional<OrderRequest> order = orderRequestRepository.findById(parsedId);
            if (order.isPresent()) return List.of(order.get());
        } catch (Exception ignored) {}

        return List.of();
    }

    private Date estimateDeliveryDate(Integer orderLength) {

        int estimatedDays = 3;

        if (orderLength > 5 && orderLength < 15) estimatedDays = 5;
        else if (orderLength >= 15) estimatedDays = 10;


        LocalDate fecha = LocalDate.now();
        for (int i = 0; i < estimatedDays; i++) {
            fecha = fecha.plusDays(1);
            if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) i--;
        }


        return java.sql.Date.valueOf(fecha);
    }

    private Double calculateTotal(OrderRequest orderRequest) {

        Double total = orderRequest.getTotalAmount();

        Double calculatedTotal = orderRequest.getOrderDetail()
                .stream()
                .mapToDouble(detail -> {
                    Product product = productService.findById(detail.getProductId());
                    return detail.getQuantity() * product.getPrice();
                })
                .sum();

        if (calculatedTotal.equals(total)) return total;

        return calculatedTotal;
    }

}