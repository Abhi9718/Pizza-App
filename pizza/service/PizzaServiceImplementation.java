package com.example.pizza.service;

import com.example.pizza.exception.PizzaNotFoundException;
import com.example.pizza.exception.UserNotFoundException;
import com.example.pizza.model.Commondata;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.User;
import com.example.pizza.model.UserDTO;
import com.example.pizza.proxy.UserProxy;
import com.example.pizza.repository.PizzaRepo2;
import com.example.pizza.repository.PizzaRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class PizzaServiceImplementation implements PizzaService{
    @Autowired
    PizzaRepos pizzaRepos;
    @Autowired
    PizzaRepo2 pizzaRepo2;
    @Autowired
    UserProxy userProxy;
    @Override
    public User registerUser(Commondata commondata) {
        UserDTO userDTO=new UserDTO();
        userDTO.setEmail(commondata.getEmail());
        userDTO.setPassword(commondata.getPassword());
        userDTO.setUserName(commondata.getUserName());
        userDTO.setMobileNo(commondata.getMobileNo());
        ResponseEntity<?> responseEntity=userProxy.sendUserCredentialsToUserAuthenticationApp(userDTO);

        User user=new User(commondata.getEmail(), commondata.getMobileNo(), commondata.getAddress(), new ArrayList());
        return pizzaRepos.insert(user);
    }
    @Override
    public User saveUser(User user) {
        return pizzaRepos.save(user);
    }

    @Override
    public Pizza savePizza(Pizza pizza) {
        return pizzaRepo2.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepo2.findAll();
    }


    @Override
    public User savePizza(Pizza pizza, String email) throws UserNotFoundException {
        if(pizzaRepos.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = pizzaRepos.findById(email).get();
        if(user.getPizza() == null)
        {
            user.setPizza(Arrays.asList(pizza));
        }
        else {
            List<Pizza> piz = user.getPizza();
            piz.add(pizza);
            user.setPizza(piz);
        }
        return pizzaRepos.save(user);
    }
    @Override
    public List<User> showAllItems() {
        return pizzaRepos.findAll();
    }

    @Override
    public User deletePizza(String email, String pizzaName) throws UserNotFoundException, PizzaNotFoundException {
        boolean pizzaNameIsPresent = false;
        if(pizzaRepos.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = pizzaRepos.findById(email).get();
        List<Pizza> pizzas = user.getPizza();
        pizzaNameIsPresent = pizzas.removeIf(x->x.getPizzaName().equals(pizzaName));
        if(!pizzaNameIsPresent)
        {
            throw new PizzaNotFoundException();
        }
        user.setPizza(pizzas);
        return pizzaRepos.save(user);
    }


    @Override
    public User getUser(String email) {
        return pizzaRepos.findById(email).get();
    }
}
