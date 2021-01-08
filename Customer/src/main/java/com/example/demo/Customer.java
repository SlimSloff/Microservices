package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 795450928237931201L;
		
		@Id
		@GeneratedValue
		private int id;
		private String name, username, email, adress;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		
		
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customer(String name, String username, String email, String adress) {
			super();
			this.name = name;
			this.username = username;
			this.email = email;
			this.adress = adress;
		}
}
