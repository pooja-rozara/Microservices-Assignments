package com.capgemini.cart.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@Column(name = "id")
	private int userid;
	@Column(name = "items")
	@ElementCollection
	private List<CartItem> items = new ArrayList<CartItem>();
	public Cart(int userid, List<CartItem> items) {
		super();
		this.userid = userid;
		this.items = items;
	}
	public Cart() {
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
