package com.example.pizza.service;

import com.example.pizza.exception.PizzaNotFoundException;
import com.example.pizza.exception.UserNotFoundException;
import com.example.pizza.model.Commondata;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.User;

import java.util.List;

public interface PizzaService {

    User registerUser(Commondata commondata);
    User saveUser(User user);

   Pizza savePizza(Pizza pizza);

   List<Pizza> getAllPizzas();
    public User savePizza(Pizza pizza, String email) throws UserNotFoundException;
    public List<User> showAllItems();

    User deletePizza(String email,String pizzaName) throws UserNotFoundException, PizzaNotFoundException;

    //User update(Pizza pizza,String email) throws UserNotFoundException;

    User getUser(String email);


}
