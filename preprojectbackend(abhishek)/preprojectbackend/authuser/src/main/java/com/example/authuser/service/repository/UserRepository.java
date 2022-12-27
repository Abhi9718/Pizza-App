package com.example.authuser.service.repository;

import com.example.authuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> { //it has all methods such as save,findAll etc.
    User findByEmailAndPassword(String email,String password);
}
