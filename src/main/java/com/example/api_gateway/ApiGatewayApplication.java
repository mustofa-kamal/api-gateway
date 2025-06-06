package com.example.api_gateway;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


	@Bean
	public ApplicationRunner runner(Environment env) {
		return args -> {
			System.out.println("✅ Loaded route ID: " + env.getProperty("spring.cloud.gateway.routes[0].id"));
			System.out.println("✅ Target URI: " + env.getProperty("spring.cloud.gateway.routes[0].uri"));
			System.out.println("✅ Predicate Path: " + env.getProperty("spring.cloud.gateway.routes[0].predicates[0]"));
		};
	}

}
