package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@EnableEurekaClient
@RestController
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Autowired
	private CustomerRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			repository.save(new Customer("Mariem", "Ch", "ma@esprit.tn", "Ariana"));
			repository.save(new Customer("Sarra", "ab", "sa@esprit.tn", "Ariana"));
			repository.save(new Customer("Mohamed", "ba", "mo@esprit.tn", "jvispdj"));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}
