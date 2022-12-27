package com.example.authuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data //getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class  User {
    @Id
    private String employeeName;
   // private String enterYourDesignation;
    private String email;
    private String password;
//    private String confirmYourPassword;
//    private String userName;
//    private String mobileNo;
}
