package com.chapinstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer orderRequestId;

    @Column(nullable = false)
    private Long productId;

}