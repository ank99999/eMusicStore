package com.musicstore.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.DAO.customerDAO;
import com.musicstore.model.Customer;
import com.musicstore.service.customerService;

@Service
public class customerrServiceImpl implements customerService{
	@Autowired
	private customerDAO customerDAO;

	@Override
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerDAO.getCustomerById(id);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerDAO.getAllCustomer();
		return customerList;
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		Customer customer = customerDAO.getCustomerByUserName(userName);
		return customer;
	}

	@Override
	public Long getCustomerIdByUserName(String userName) {
		return customerDAO.getCustomerIdByUserName(userName);
	}
	
	

}
