package com.chapinstore.common.mapper;

import com.chapinstore.dto.product.request.ProductCreationDtoRequest;
import com.chapinstore.dto.product.response.ProductCreationDtoResponse;
import com.chapinstore.dto.product.response.ProductRetrieveDtoResponse;
import com.chapinstore.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductRetrieveDtoResponse toProductRetrieveDtoResponse(Product product);
    Product toProduct(ProductCreationDtoRequest productCreationDtoRequest);
    ProductCreationDtoResponse toProductCreationDtoResponse(Product product);

}