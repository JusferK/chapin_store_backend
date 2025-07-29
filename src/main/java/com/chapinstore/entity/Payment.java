package com.chapinstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(length = 45, nullable = false)
    private String cardHolder;

    @Column(nullable = false, length = 4)
    private String lastFourDigits;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Column(length = 16, nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(length = 45, nullable = false)
    private String customerEmail;

}
