package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository CustomereRespository;

	public Customer addCustomer(Customer Customere) {
		return CustomereRespository.save(Customere);
	}
	
	public Customer updateCustomer(int id, Customer newCustomer) {
		if (CustomereRespository.findById(id).isPresent()) {
			Customer existingCustomer = CustomereRespository.findById(id).get();
			existingCustomer.setName(newCustomer.getName());
			existingCustomer.setUsername(newCustomer.getUsername());
			existingCustomer.setEmail(newCustomer.getEmail());
			existingCustomer.setAdress(newCustomer.getAdress());


			return CustomereRespository.save(existingCustomer);
		} else
			return null;
	}
	
	public String deleteCustomer(int id) {
		if (CustomereRespository.findById(id).isPresent()) {
			CustomereRespository.deleteById(id);
			return "Customer supprimé";
		} else
			return "Customer non supprimé";
	}
}
