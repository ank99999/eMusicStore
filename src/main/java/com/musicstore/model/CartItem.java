package com.musicstore.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "CartItem")
public class CartItem implements Serializable{

	private static final long serialVersionUID = -9109388880072670637L;

	@Id
	@GeneratedValue
	@Column(name = "cartItemId")
	private long cartItemId;
	
	@ManyToOne()
	@JoinColumn(name="productID")
	private Product product;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "totalPrice")
	private double totalPrice;
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
