package com.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.musicstore.model.Customer;
import com.musicstore.service.customerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	private customerService customerService; 
	
	@RequestMapping
	public String getCart(@AuthenticationPrincipal User activeuser, Model model){
		Customer customer = customerService.getCustomerByUserName(activeuser.getUsername());
		Long cartId = customer.getCart().getCartId();
		return "redirect:/customer/cart/"+cartId;
	}
	
	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable Long cartId ,Model model){
		System.out.println("--------------------------------------------------------------"+cartId);
		model.addAttribute("cartId", cartId);
		return "cart";
	}

}
