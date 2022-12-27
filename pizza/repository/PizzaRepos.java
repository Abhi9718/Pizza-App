package com.example.pizza.repository;

import com.example.pizza.model.Pizza;
import com.example.pizza.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepos extends MongoRepository<User,String> {

//    User findByEmail(String email);
}


