package com.capgemini.price.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Price")
public class Price {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "price")
	private double price;
	public Price() {
		super();
	}
	public Price(int id, double price) {
		super();
		this.id = id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
