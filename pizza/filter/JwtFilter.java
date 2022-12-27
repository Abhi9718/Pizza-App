package com.example.pizza.filter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class JwtFilter extends GenericFilterBean {
    @Override
    //doFilter is predefined method
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //check request header :OPTIONS-> skip filtering,head with bearer token:check the token :process the request
        HttpServletRequest request= (HttpServletRequest) servletRequest; //Downcasting the servlet request
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String authHeader=request.getHeader("authorization");

        System.out.println( "Authheader "+authHeader);
        System.out.println( "method "+request.getMethod());
        //if any request  is options type not going to filter
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
        }
        //if authheader not found / header found but token not bearer type
        else if(authHeader==null || !authHeader.startsWith("Bearer") ){
            throw new ServletException("Missing or Invalid Exception");
        }
        //if authheader found with proper bearer token
        String token=authHeader.substring(7);//Bearer abcdxyz ->get =abcdxyz //Bearer is removed
        System.out.println( "token "+token);
        Claims claims= Jwts.parser().setSigningKey("mytoken").parseClaimsJws(token).getBody(); //getting claims content of payload
        System.out.println("claims in filter "+claims);
        request.setAttribute("claims",claims);//
        filterChain.doFilter(request,response);


    }

}
