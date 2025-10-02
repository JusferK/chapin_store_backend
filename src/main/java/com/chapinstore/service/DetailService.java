package com.chapinstore.service;

import com.chapinstore.common.mapper.DetailMapper;
import com.chapinstore.dto.detail.request.DetailCreationRequestDto;
import com.chapinstore.dto.detail.request.DetailUpdateRequestDto;
import com.chapinstore.dto.detail.response.DetailRetrieveDto;
import com.chapinstore.entity.Detail;
import com.chapinstore.entity.OrderRequest;
import com.chapinstore.entity.Product;
import com.chapinstore.enums.Status;
import com.chapinstore.repository.DetailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    @Lazy
    private OrderRequestService orderRequestService;

    public List<Detail> create(
            List<DetailCreationRequestDto> detailCreationRequestDto,
            Integer orderId
    ) {
        List<Detail> details = detailCreationRequestDto
                .stream()
                .map(detail -> detailMapper.toDetail(detail))
                .peek(detail -> productService.findById(detail.getProductId()))
                .peek(detail -> detail.setOrderRequestId(orderId))
                .toList();

        return detailRepository.saveAll(details);
    }

    public Map<String, Boolean> update(DetailUpdateRequestDto detailDto, Integer orderRequestId) {

        OrderRequest orderRequest = orderRequestService.findById(orderRequestId);

        if (
                orderRequest.getStatus().toString().equals(Status.CANCELLED.toString()) ||
                orderRequest.getStatus().toString().equals(Status.DELIVERED.toString())
        ) return Map.of("updated", false);

        Detail detail = detailRepository.findById(detailDto.getOrderDetailId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el detalle"));

        return updateDetail(detail, detailDto, orderRequest);
    }

    public DetailRetrieveDto map(Detail detail) {
        return detailMapper.toDetailRetrieveDto(detail);
    }

    private Map<String, Boolean> updateDetail(
            Detail detail,
            DetailUpdateRequestDto detailDto,
            OrderRequest orderRequest
    ) {

        if (detail.getQuantity().equals(detailDto.getQuantity())) return Map.of("updated", false);

        detail.setQuantity(detailDto.getQuantity());

        Product findProduct = productService.findById(detail.getProductId());
        detail.setSubtotal(detailDto.getQuantity() * findProduct.getPrice());

        detailRepository.save(detail);

        Double total = orderRequest.getOrderDetail()
                .stream()
                .mapToDouble(d -> {
                    Product p = productService.findById(d.getProductId());
                    return d.getQuantity() * p.getPrice();
                })
                .sum();

        orderRequest.setTotalAmount(total);

        return Map.of("updated", true);
    }



}
