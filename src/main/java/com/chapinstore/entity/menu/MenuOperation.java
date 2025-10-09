package com.chapinstore.entity.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuOperation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String label;

    @Column(nullable = false, length = 40)
    private String icon;

    @Column(nullable = false, length = 60)
    private String routerLink;

    @JsonIgnore
    private Long fatherId;

    @Column(nullable = false)
    private Boolean isFather;

    @OneToMany(
            mappedBy = "fatherId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MenuOperation> items;

}
