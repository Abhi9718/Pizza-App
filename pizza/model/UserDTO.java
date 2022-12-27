package com.example.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//is to create a Data Transfer Object that can hold all the data for the call.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String email;
    private String password;
    private String userName;
    private String mobileNo;
}
//    private String email;
//    private String password;
//    private String userName;
//    private String mobileNo;
//    private String address;