package com.example.authuser.token;

import com.example.authuser.model.User;

import java.util.Map;

public interface TokenGenerator {
    Map<String,String> generateToken(User user);
}
