package com.musicstore.DAO;

import java.util.List;
import com.musicstore.model.Customer;

public interface customerDAO {
	
	void addCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	void updateCustomer(Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomer();
	Customer getCustomerByUserName(String userName);
	Long getCustomerIdByUserName(String userName);

}
