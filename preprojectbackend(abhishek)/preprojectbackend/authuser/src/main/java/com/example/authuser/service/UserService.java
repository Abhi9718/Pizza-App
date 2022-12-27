package com.example.authuser.service;

import com.example.authuser.exceptions.InvalidCredentials;
import com.example.authuser.exceptions.UserAlreadyFoundException;
import com.example.authuser.model.User;

public interface UserService {

    User addUser(User user) throws UserAlreadyFoundException;
    User findByEmailAndPassword(String email,String password) throws InvalidCredentials;
}
