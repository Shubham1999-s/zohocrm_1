package com.crm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(unique=true)
	private String email;
	
	private long mobile;
	private String product;
	private int price;
	public long getId() {
	return id;
	}
	public void setId(long id) {
	this.id = id;
	}
	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	public String getLastName() {
	return lastName;
	}
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public long getMobile() {
	return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
		}
		public String getProduct() {
		return product;
		}
		public void setProduct(String product) {
		this.product = product;
		}
		public int getPrice() {
		return price;
		}
		public void setPrice(int price) {
		this.price = price;

}
}
