package com.example.authuser.controller;

import com.example.authuser.exceptions.InvalidCredentials;
import com.example.authuser.exceptions.UserAlreadyFoundException;
import com.example.authuser.model.User;
import com.example.authuser.service.UserService;
import com.example.authuser.token.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    //  userService object gets UserServiceImplementation class body
    @Autowired
    TokenGenerator tokenGenerator;
    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyFoundException {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }



    @PostMapping("/login")
    public ResponseEntity<?> check(@RequestBody User user) throws InvalidCredentials {
        User store = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
        //authentication sucess
        if(store !=null){
            Map<String,String> key=tokenGenerator.generateToken(user);
            return new ResponseEntity<>(key,HttpStatus.ACCEPTED);
        }
        //authentication fail
        else {
            return new ResponseEntity<>("Authentication Failed",HttpStatus.NOT_FOUND);
        }
    }

}
