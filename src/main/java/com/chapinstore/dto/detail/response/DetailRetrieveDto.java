package com.chapinstore.dto.detail.response;

import com.chapinstore.dto.product.response.ProductRetrieveDtoResponseV2;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailRetrieveDto {

    private Long detailId;
    private Double subtotal;
    private Integer quantity;
    private ProductRetrieveDtoResponseV2 product;


}
