package com.chapinstore.common.mapper;

import com.chapinstore.dto.order_request.request.OrderRequestCreationDto;
import com.chapinstore.dto.order_request.response.OrderRequestCreationResponseDto;
import com.chapinstore.dto.order_request.response.OrderRequestRetrieveDto;
import com.chapinstore.entity.OrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper {

    OrderRequestRetrieveDto toOrderRequestRetrieveDto(OrderRequest orderRequest);
    OrderRequest toOrderRequest(OrderRequestCreationDto orderRequestCreationDto);
    OrderRequestCreationResponseDto toOrderRequestCreationResponseDto(OrderRequest orderRequest);

}
