package ru.mg.microservices.services.routeheplers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;
import ru.mg.microservices.routehelpers.RouteHelperServiceConfig;


@SpringBootApplication
@EnableEurekaServer
@Import(RouteHelperServiceConfig.class)
public class RouteHelperServer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "routeheplers-server");

		SpringApplication.run(RouteHelperServer.class, args);
	}
}
