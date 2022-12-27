package com.example.pizza.repository;

import com.example.pizza.model.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //this repository is data acess object that acess database directly
public interface PizzaRepo2 extends MongoRepository<Pizza,String> {
}
