package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.name like :name")
	public Page<Customer> customerByName(@Param("name") String n, Pageable pageable);
	//List <Customer> findById(int o);
}
