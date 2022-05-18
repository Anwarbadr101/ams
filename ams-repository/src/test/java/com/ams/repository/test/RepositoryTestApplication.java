package com.ams.repository.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ams.model")
@EnableJpaRepositories("com.ams.repository")
public class RepositoryTestApplication {

}