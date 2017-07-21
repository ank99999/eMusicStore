package com.musicstore.service;

import com.musicstore.model.CustomerOrder;

public interface orderService {
    
	void addCustomerOrder(CustomerOrder order); 
	double orderTotal(Long cartId);

}
