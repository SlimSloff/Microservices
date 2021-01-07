package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import com.esprit.microservices.StockRepository;
@EnableDiscoveryClient
@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}
	@Autowired
	private StockRepository StockRepository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			StockRepository.save(new Stock("Ch", "hh",11));
			// fetch
			StockRepository.findAll().forEach(System.out::println);

		};
	}
}
