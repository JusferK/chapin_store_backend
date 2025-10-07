package com.chapinstore.entity.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String token;

    private Boolean valid;

    public JwtToken() {}

    public JwtToken(String token) {
        this.token = token;
        this.valid = false;
    }

}