package com.capgemini.count.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prod_count")
public class Count {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "pcount")
	private int count;
	public Count() {
		super();
	}
	public Count(int id, int count) {
		super();
		this.id = id;
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return count;
	}
	public void setPrice(int count) {
		this.count = count;
	}
	
}
