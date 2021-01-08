package com.esprit.microservices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface SAVRepository extends JpaRepository<SAV,Integer>{
	@Query("select c from SAV c where c.id like :id")
	public Page<SAV> SAVById(@Param("id") String n, Pageable pageable);
}
