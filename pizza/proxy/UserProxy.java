package com.example.pizza.proxy;

import com.example.pizza.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication-service",url="localhost:8088")
public interface UserProxy {  // implements exactly the interfaces specified at its creation, in the same order.
    @PostMapping("/user/signup")
    public ResponseEntity<?> sendUserCredentialsToUserAuthenticationApp(@RequestBody UserDTO userDTO);
}

