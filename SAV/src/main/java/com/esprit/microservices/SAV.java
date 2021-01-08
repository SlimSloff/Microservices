package com.esprit.microservices;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class SAV implements Serializable {
public SAV() {
		super();
		// TODO Auto-generated constructor stub
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSatstisfaction() {
		return satstisfaction;
	}
	public void setSatstisfaction(String satstisfaction) {
		this.satstisfaction = satstisfaction;
	}
	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
	}
public SAV(String satstisfaction, String avis) {
		super();
		this.satstisfaction = satstisfaction;
		this.avis = avis;
	}
private static final long serialVersionUID = 795450928237931201L;
	
	@Id
	@GeneratedValue
	private int id;
	private String satstisfaction,avis;

}
