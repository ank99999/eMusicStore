package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Customer;

public interface customerService {
	
	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomers();
	Customer getCustomerByUserName(String userName);
	Long getCustomerIdByUserName(String userName);

}
