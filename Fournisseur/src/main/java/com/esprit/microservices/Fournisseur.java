package com.esprit.microservices;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Fournisseur implements Serializable  {
private static final long serialVersionUID = 795450928237931201L;
	
	@Id
	@GeneratedValue
	private int id;
private String nomf,mobile,email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomf() {
	return nomf;
}
public void setNomf(String nomf) {
	this.nomf = nomf;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Fournisseur() {
	super();
	// TODO Auto-generated constructor stub
}
public Fournisseur(String nomf, String mobile, String email) {
	super();
	this.nomf = nomf;
	this.mobile = mobile;
	this.email = email;
}


	
}
