package com.chapinstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Boolean enabled;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public Administrator() {}

}
