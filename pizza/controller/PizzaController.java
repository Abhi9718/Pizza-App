package com.example.pizza.controller;

import com.example.pizza.exception.PizzaNotFoundException;
import com.example.pizza.exception.UserNotFoundException;
import com.example.pizza.model.Commondata;
import com.example.pizza.model.Pizza;
import com.example.pizza.model.User;
import com.example.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizza-app")//it is used to map the web requests
public class PizzaController {
    @Autowired
    PizzaService pizzaService;
    @PostMapping("/reg")
    public ResponseEntity<?> registerUserAccountInMongoAndSql(@RequestBody Commondata commondata){
        return new ResponseEntity<>(pizzaService.registerUser(commondata),HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(pizzaService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("/addpizza/{email}") //it maps Http post
    public ResponseEntity<?> saveMyPizza(@RequestBody Pizza pizza ,@PathVariable String email) throws UserNotFoundException {
        return new ResponseEntity<>(pizzaService.savePizza(pizza,email),HttpStatus.OK);
    }
    @GetMapping("/show") //it maps the Http GET
    public ResponseEntity<?> showAllPizzas(){
        return new ResponseEntity<>(pizzaService.showAllItems(),HttpStatus.OK);
    }



    @DeleteMapping("/delete/{email}/{pizzaName}")
    public ResponseEntity<?> deletePizza(@PathVariable String email, @PathVariable String pizzaName) throws UserNotFoundException, PizzaNotFoundException {
        return new ResponseEntity<>(pizzaService.deletePizza(email,pizzaName),HttpStatus.OK);
    }

    @PostMapping("/savepizza")
    public ResponseEntity<?> storePizzaInMongo(@RequestBody Pizza pizza){//It is used to bind HTTP request with an object
        return new ResponseEntity<>(pizzaService.savePizza(pizza),HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getPizza(){
        return new ResponseEntity<>(pizzaService.getAllPizzas(),HttpStatus.OK);
    }
    @GetMapping("/userpizzas/{email}")
    public ResponseEntity<?> getPizzas(@PathVariable String email){ // It is used to extract the values from the URl
        return new ResponseEntity<>(pizzaService.getUser(email),HttpStatus.OK);
    }
}
