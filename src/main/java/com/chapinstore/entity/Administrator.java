package com.chapinstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Administrator {

    @Id
    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 45)
    private String password;

}
