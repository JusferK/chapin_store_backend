package com.chapinstore.entity;

import com.chapinstore.enums.Country;
import com.chapinstore.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer addressId;

    @Column(length = 45, nullable = false)
    private String street;

    @Column(length = 45, nullable = false)
    private String house;

    @Column(length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private Department city;

    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Country country = Country.GUATEMALA;

    @Column(length = 45, nullable = false)
    private String neighborhood;

    @Column(length = 45, nullable = false)
    private String customerEmail;

}
