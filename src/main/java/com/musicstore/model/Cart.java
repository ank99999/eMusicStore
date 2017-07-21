package com.musicstore.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cart")
public class Cart implements Serializable{
	
	private static final long serialVersionUID = -1675390339537861560L;

	@Id
	@GeneratedValue
	@Column(name = "cartId")
	private long cartId;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> listCartItems;
		
	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	
/*	@OneToOne
	@JoinColumn(name = "orderId")
	private Order order;*/
	
	@Column(name = "grandTotal")
	private double grandTotal;
	
	public long getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<CartItem> getListCartItems() {
		return listCartItems;
	}

	public void setListCartItems(List<CartItem> listCartItems) {
		this.listCartItems = listCartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
