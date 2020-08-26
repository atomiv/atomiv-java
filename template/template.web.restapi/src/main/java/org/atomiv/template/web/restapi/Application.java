package org.atomiv.template.web.restapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;

@SpringBootApplication
@EnableJpaRepositories("org.atomiv.template.infrastructure.persistence.jpa.repos")
@EntityScan("org.atomiv.template.infrastructure.persistence.jpa.records")
@ComponentScan(basePackages = "org.atomiv.template")
@ComponentScan(basePackages = "org.atomiv.template.core.application.commands.customers")
@ComponentScan(basePackages = "org.atomiv.template.core.application.commands.products")
@ComponentScan(basePackages = "org.atomiv.template.core.application.commands.handlers.customers")
@ComponentScan(basePackages = "org.atomiv.template.core.application.commands.handlers.products")
@ComponentScan(basePackages = "org.atomiv.template.core.application.queries.customers")
@ComponentScan(basePackages = "org.atomiv.template.core.application.queries.products")
@ComponentScan(basePackages = "org.atomiv.template.infrastructure.persistence.jpa")
@ComponentScan(basePackages = "org.atomiv.template.infrastructure.persistence.jpa")
@ComponentScan(basePackages = "org.atomiv.template.infrastructure.queries.handlers.customers.jpa")
@ComponentScan(basePackages = "org.atomiv.template.infrastructure.queries.handlers.products.jpa")
@Configuration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	Pipeline pipeline(ObjectProvider<Command.Handler> commandHandlers, ObjectProvider<Notification.Handler> notificationHandlers, ObjectProvider<Command.Middleware> middlewares) {
        return new Pipelinr()
	        .with(commandHandlers::stream)
	        .with(notificationHandlers::stream)
	        .with(middlewares::orderedStream);
	}
}
