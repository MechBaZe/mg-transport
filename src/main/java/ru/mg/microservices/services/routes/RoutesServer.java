package ru.mg.microservices.services.routes;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import ru.mg.microservices.routes.RoutesServiceConfig;

@SpringBootApplication
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
