package com.esprit.microservices;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 795450928237931201L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String description,type;
	private int quantite;


	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String description, String type, int quantite) {
		super();
		this.description = description;
		this.type = type;
		this.quantite = quantite;
	}
	public Stock(int id) {
		super();
		this.id = id;
	}
	
	
	

}
