package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class SavApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavApplication.class, args);
	}
	@Autowired
	private SAVRepository SAVRepository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			SAVRepository.save(new SAV("Ch", "hh"));
			// fetch
			SAVRepository.findAll().forEach(System.out::println);

		};
	
	}
}
