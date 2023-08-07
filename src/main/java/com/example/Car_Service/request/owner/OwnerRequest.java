package com.example.Car_Service.request.owner;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OwnerRequest {

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
}
