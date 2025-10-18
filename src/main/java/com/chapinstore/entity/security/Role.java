package com.chapinstore.entity.security;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            unique = true,
            nullable = false,
            length = 30
    )
    private String name;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(
            mappedBy = "role",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<GrantedPermission> permissions = new ArrayList<>();

    public Role(String name) {
        this.name = name;
        this.active = true;
    }

}
