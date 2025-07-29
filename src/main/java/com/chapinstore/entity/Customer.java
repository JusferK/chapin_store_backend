package com.chapinstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @Column(length = 45, unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 45)
    private String password;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Lob
    private String profilePhoto;

    @OneToMany(
            mappedBy = "customerEmail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Payment> paymentMethods = new ArrayList<>();

    @Size(min = 1, max = 1)
    @OneToMany(
            mappedBy = "customerEmail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CustomerAddress> addresses = new ArrayList<>();

    @OneToMany(
            mappedBy = "customerEmail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderRequest> orders = new ArrayList<>();

}
