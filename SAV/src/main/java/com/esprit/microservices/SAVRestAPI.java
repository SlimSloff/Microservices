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
@RequestMapping(value = "/api/SAV")
public class SAVRestAPI {
	private String title="Hello , I'm the SAV";
	@Autowired
	private SAVService SAVService;
	
	
	@Autowired
	private SAVRepository CustomereRespository;
	
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		
		return title;
}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SAV> createSAV(@RequestBody SAV sav) {
		return new ResponseEntity<>(SAVService.addSAV(sav), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SAV> updateSAV(@PathVariable(value = "id") int id,
    @RequestBody SAV sav){
		return new ResponseEntity<>(SAVService.updateSAV(id,sav), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteSAV(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(SAVService.deleteSAV(id), HttpStatus.OK);
	}
	
	// get cust by id
	
	@GetMapping("/{id}")
	public Optional<SAV> getCustById(@PathVariable int id)
	{		
		return  CustomereRespository.findById(id);
				}
	
// get all
	@GetMapping("/all")
	public List<SAV> getCust()
	{		
		return  CustomereRespository.findAll();
				}
	

}
