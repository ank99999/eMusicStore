package com.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.musicstore.model.Cart;
import com.musicstore.model.Customer;
import com.musicstore.model.CustomerOrder;
import com.musicstore.service.cartService;
import com.musicstore.service.orderService;

@Controller
public class OrderController {
	
	@Autowired
	private cartService cartService;
	
	@Autowired 
	private orderService orderService;

	@RequestMapping("/order/{cartId}")
	public String addCustomerOrder(@PathVariable Long cartId){
		Cart cart = cartService.getCartById(cartId);
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCart(cart);
		
		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());
		
		orderService.addCustomerOrder(customerOrder);
		
		return "redirect:/checkout?cartId="+cartId;
	}
	
	
}
