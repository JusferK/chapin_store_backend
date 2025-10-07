package com.chapinstore.entity.security;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String path;

    private String method;

    private Boolean permitAll;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
    private Module module;

}