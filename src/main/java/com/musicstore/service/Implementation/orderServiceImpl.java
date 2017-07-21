package com.musicstore.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.musicstore.model.Cart;
import com.musicstore.model.CustomerOrder;
import com.musicstore.service.orderService;
import com.musicstore.DAO.orderDAO;
import com.musicstore.service.cartService;

@Service
public class orderServiceImpl implements orderService{
	@Autowired
	private orderDAO orderDAO;
	
	@Autowired
	private cartService cartService;

	@Override
	public void addCustomerOrder(CustomerOrder order) {
		
		orderDAO.addCustomerOrder(order);
		
	}

	@Override
	public double orderTotal(Long cartId) {
	   Cart cart = cartService.getCartById(cartId);
	   return cart.getGrandTotal();
	}
	
	

}
