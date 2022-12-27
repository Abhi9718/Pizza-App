package com.example.authuser.token;

import com.example.authuser.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class TokenGeneratorImplementation implements TokenGenerator{

    @Override
    public Map<String, String> generateToken(User user) {
        Map <String,String> result=new HashMap<String,String>();
        Map<String,Object> data=new HashMap<>();
        data.put("userObjcet",user);
        String jwtToken= Jwts.builder().setClaims(data).
                    setIssuedAt(new Date()).
                    signWith(SignatureAlgorithm.HS512,"mytoken").
                    compact();
            result.put("token",jwtToken);
            return result;
        }

}
