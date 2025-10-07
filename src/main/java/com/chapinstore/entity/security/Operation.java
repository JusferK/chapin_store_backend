package com.chapinstore.entity.security;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            unique = true,
            nullable = false,
            length = 60
    )
    private String name;

    @Column(
            nullable = false,
            length = 100
    )
    private String path;

    @Column(
            nullable = false,
            length = 10
    )
    private String method;

    @Column(nullable = false)
    private Boolean permitAll;

    @Column(nullable = false)
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
    private Module module;

}