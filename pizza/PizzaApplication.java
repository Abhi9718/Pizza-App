package com.example.pizza;

import com.example.pizza.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableFeignClients //it is use to microservices can communicate with each other
public class PizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}
	@Bean //it means load automatically
	public FilterRegistrationBean jwtFilter(){
		//returns list of intercepted URLs with defined JwtFilter class

		FilterRegistrationBean frb=new 	FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		//frb.addUrlPatterns("/customerdata/customer");//addCustomer
		///pizza-app/addpizza/* (base Url)
		frb.addUrlPatterns("/pizza-app/addpizza/*","/pizza-app/update/*");//* means after this amy parameter has all things are alot
		return frb;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		final CorsConfiguration configuration=new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedOrigin("http://localhost:4200");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",configuration);

		FilterRegistrationBean bean=new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return bean;
	}

}
