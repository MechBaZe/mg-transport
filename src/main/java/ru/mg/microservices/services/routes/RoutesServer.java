package ru.mg.microservices.services.routes;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import ru.mg.microservices.accounts.AccountRepository;
import ru.mg.microservices.accounts.AccountsConfiguration;
import ru.mg.microservices.routes.RoutesRepository;
import ru.mg.microservices.routes.RoutesServiceConfig;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(RoutesServiceConfig.class)
public class RoutesServer {
	private Logger logger = Logger.getLogger(RoutesServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "routes-server");
		SpringApplication.run(RoutesServer.class, args);
	}
}
