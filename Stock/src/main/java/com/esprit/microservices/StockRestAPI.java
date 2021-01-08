package com.esprit.microservices;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;






@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/stocks")
public class StockRestAPI {
	private String title="Hello , I'm the Stock Microservice";
	@Autowired
	private StockService StockService;
	
	@Autowired	
	private StockRepository stockRepo;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		
		return title;
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
		return new ResponseEntity<>(StockService.addStock(stock), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Stock> updateStock(@PathVariable(value = "id") int id,
    @RequestBody Stock stock){
		return new ResponseEntity<>(StockService.updateStock(id,stock), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStock(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(StockService.deleteStock(id), HttpStatus.OK);
	}
	
	// get cust by id
	
			@GetMapping("/{id}")
			public Optional<Stock> getCustById(@PathVariable int id)
			{		
				return  stockRepo.findById(id);
						}
			
	 // get all
			@GetMapping("/all")
			public List<Stock> getCust()
			{		
				return  stockRepo.findAll();
						}
}
