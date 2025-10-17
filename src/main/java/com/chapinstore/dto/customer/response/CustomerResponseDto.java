package com.chapinstore.dto.customer.response;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerResponseDto {

    private String email;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String profilePhoto;
    private Date creationDate;

}
