package com.chapinstore.entity.menu;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
public class RoleMenu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long menuOperationId;

    @Column(nullable = false)
    private Long roleId;

    public RoleMenu() {}

    public RoleMenu(Long roleId, Long menuOperationId) {
        this.roleId = roleId;
        this.menuOperationId = menuOperationId;
    }

}
