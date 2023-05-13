package com.ssafy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssafy.auth"})
public class AuthenticationHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationHomeApplication.class, args);
	}

}
