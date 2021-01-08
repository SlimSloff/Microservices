package com.esprit.microservices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface StockRepository extends JpaRepository<Stock,Integer>{
	@Query("select c from Stock c where c.description like :description")
	public Page<Stock> stockByDescription(@Param("description") String n, Pageable pageable);
}
