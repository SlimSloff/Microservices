package com.esprit.microservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class FournisseurApplication {

	public static void main(String[] args) {
		SpringApplication.run(FournisseurApplication.class, args);
	}
	@Autowired
	private FournisseurRepository FournisseurRepository;
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			FournisseurRepository.save(new Fournisseur("hh", "Ch", "hh"));
			// fetch
			FournisseurRepository.findAll().forEach(System.out::println);

		};
	}
}
