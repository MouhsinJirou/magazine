package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"org.beans"}) 
//@ComponentScan({"org.sid","org.controller"})
public class MiniProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjetApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCrypt() {
		return new BCryptPasswordEncoder();
	}

}
