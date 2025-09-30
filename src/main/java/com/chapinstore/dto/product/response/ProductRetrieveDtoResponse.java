package com.chapinstore.dto.product.response;

import lombok.Data;

@Data
public class ProductRetrieveDtoResponse {

    private Integer productId;
    private String name;
    private String description;
    private Double price;
    private String image;

}
