package com.chapinstore.dto.authentication.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse<T> {

    private String token;
    private T data;

    public AuthenticationResponse(String token, T data) {
        this.token = token;
        this.data = data;
    }

}
