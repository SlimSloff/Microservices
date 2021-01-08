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
@RequestMapping(value = "/api/fournisseur")
public class FournisseurRestAPI {
	private String title="Hello , I'm hichem";
	@Autowired
	private FournisseurService FournisseurService;
	@Autowired
	private FournisseurRepository CustomereRespository;
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		
		return title;
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
		return new ResponseEntity<>(FournisseurService.addFournisseur(fournisseur), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") int id,
    @RequestBody Fournisseur fournisseur){
		return new ResponseEntity<>(FournisseurService.updateFournisseur(id,fournisseur), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFournisseur(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(FournisseurService.deleteFournisseur(id), HttpStatus.OK);
	}
	
	
	
	// get cust by id
	
		@GetMapping("/{id}")
		public Optional<Fournisseur> getCustById(@PathVariable int id)
		{		
			return  CustomereRespository.findById(id);
					}
		
 // get all
		@GetMapping("/all")
		public List<Fournisseur> getCust()
		{		
			return  CustomereRespository.findAll();
					}
		
}
