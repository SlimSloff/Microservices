package com.example.demo;


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
@RequestMapping(value = "/api/customers")


public class CustomerRestAPI {
   
	private String title="NEW CUSTOMER ";
	
    @Autowired
	private CustomerService customerService;
    
	
	@Autowired
	private CustomerRepository CustomereRespository;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		
		return title;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> createCandidat(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Customer> updateCandidat(@PathVariable(value = "id") int id,
    										@RequestBody Customer customer){
		return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
	}

	
	// get cust by id
	
		@GetMapping("/{id}")
		public Optional<Customer> getCustById(@PathVariable int id)
		{		
			return  CustomereRespository.findById(id);
					}
		
 // get all
		@GetMapping("/all")
		public List<Customer> getCust()
		{		
			return  CustomereRespository.findAll();
					}
		
		
		
}