package org.atomiv.template.web.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "org.atomiv.template")
@ComponentScan(basePackages = "org.atomiv.template.infrastructure.persistence.jpa")
@EnableJpaRepositories("org.atomiv.template.infrastructure.repositories.jpa")
@EntityScan("org.atomiv.template.infrastructure.persistence.jpa")
@Configuration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
