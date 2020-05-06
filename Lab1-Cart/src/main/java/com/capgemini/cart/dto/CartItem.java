package com.capgemini.cart.dto;

import java.io.Serializable;

public class CartItem implements Serializable{
	private int id;
	private int itemCount;
	public CartItem() {
		super();
	}
	public CartItem(int id, int itemCount) {
		super();
		this.id = id;
		this.itemCount = itemCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", itemCount=" + itemCount + "]";
	}
	
}
