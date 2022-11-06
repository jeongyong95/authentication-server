package com.joojeongyong.authentication.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AuthenticationServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServerApplication.class, args);
	}
	
}
