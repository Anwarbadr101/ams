package com.ams.web.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ams"})
@EntityScan("com.ams.model")
@EnableJpaRepositories("com.ams.repository")
public class AmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsWebApplication.class, args);
	}

}
