package com.esprit.microservices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer>{
	@Query("select c from Fournisseur c where c.nomf like :nomf")
	public Page<Fournisseur> FournisseurByNomf(@Param("nomf") String n, Pageable pageable);

}
