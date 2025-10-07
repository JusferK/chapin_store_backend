package com.chapinstore.entity.security;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Module {

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
            unique = true,
            nullable = false,
            length = 60
    )
    private String basePath;

    @Column(nullable = false)
    private Boolean active;

    public Module() {}

    public Module(String name, String basePath) {
        this.name = name;
        this.basePath = basePath;
        this.active = true;
    }

}
