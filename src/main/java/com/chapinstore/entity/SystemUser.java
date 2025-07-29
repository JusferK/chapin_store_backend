package com.chapinstore.entity;

import com.chapinstore.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"system_user\"")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer systemUserId;

    @Column(nullable = false, length = 45)
    private String accessPoint;

    @Column(nullable = false)
    private Role role;

}
