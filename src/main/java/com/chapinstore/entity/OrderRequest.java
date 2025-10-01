package com.chapinstore.entity;

import com.chapinstore.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer orderRequestId;

    @Column(nullable = false, length = 300)
    private String shippingAddress;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private Integer paymentId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Date estimatedDeliveryDate;

    @Column(nullable = false)
    @CreationTimestamp
    private Date orderDate;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "orderRequestId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Detail> orderDetail;

}
