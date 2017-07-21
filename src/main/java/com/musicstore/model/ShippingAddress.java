package com.musicstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shippingaddress")
public class ShippingAddress implements Serializable{

	private static final long serialVersionUID = -3505393275169372442L;

	@Id
	@GeneratedValue
	@Column(name = "shippingAddressId")
	private long shippingAddressId;
	
	@Column(name = "StreetName")
	private String StreetName;
	
	@Column(name = "City")
	private String City;
	
	@Column(name = "State")
	private String State;
	
	@Column(name = "Country")
	private String Country;
	
	@OneToOne
	@JoinColumn (name = "customerId")
	private Customer customer;

	public long getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ShippingAddress [StreetName=" + StreetName + ", City=" + City + ", State=" + State + ", Country="
				+ Country + "]";
	}
}
