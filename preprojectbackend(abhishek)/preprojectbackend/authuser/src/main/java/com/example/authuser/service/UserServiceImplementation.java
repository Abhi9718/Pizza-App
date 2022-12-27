package com.example.authuser.service;

import com.example.authuser.exceptions.InvalidCredentials;
import com.example.authuser.exceptions.UserAlreadyFoundException;
import com.example.authuser.model.User;
import com.example.authuser.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) throws UserAlreadyFoundException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyFoundException();
        }
        System.out.println(user);
        return userRepository.save(user);

    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws InvalidCredentials {
        User loggedInUser = userRepository.findByEmailAndPassword(email,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new InvalidCredentials();
        }
        return loggedInUser;
    }

}

