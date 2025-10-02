package com.chapinstore.dto.product.response;

import lombok.Data;

@Data
public class ProductRetrieveDtoResponseV2 {

    private String name;
    private String description;
    private Double price;
    private String image;

}
