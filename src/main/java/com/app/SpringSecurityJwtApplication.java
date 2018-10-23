package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.app.service.UserService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class} )
@ComponentScan(basePackageClasses = UserService.class,basePackages={"com.app.service","com.app.controller","com.app.security"})
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
}
