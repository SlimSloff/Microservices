package com.esprit.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class EuerukaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuerukaApplication.class, args);
	}

}
