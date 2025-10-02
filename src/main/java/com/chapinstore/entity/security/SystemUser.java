package com.chapinstore.entity.security;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"system_user\"")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String systemUserId;

}
