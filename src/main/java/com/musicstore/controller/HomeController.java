

package com.musicstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.musicstore.model.BillingAddress;
import com.musicstore.model.Customer;
import com.musicstore.model.ShippingAddress;
import com.musicstore.service.customerService;



@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private customerService customerService;
	
    @RequestMapping("/")
	public String home(){
		return "home";
	}
	
    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required=false)String error,
    		@RequestParam(value="logout", required=false)String logout, Model model){
    	
    	if(error != null){
    		model.addAttribute("error", "Invalid credentials");
    	}
    	
    	if(logout != null){
    		model.addAttribute("logout", "Logged out Successfully");
    	}
    	
    	return "login";
    }
    
    @RequestMapping(value = "/register" ,method = RequestMethod.GET)
    public String registerCustomer(Model model){
    	Customer customer = new Customer();
    	ShippingAddress shippingaddress = new ShippingAddress();
    	BillingAddress billingaddress = new BillingAddress();
    	customer.setBillingAddress(billingaddress);
    	customer.setShippingAddress(shippingaddress);
    	model.addAttribute("customer", customer);
    	return "registerCustomer";
    }
    
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){
    	 
    	if(result.hasErrors()){
    		return "registerCustomer";
    	}
    	
    	
    	List<Customer> customerList = customerService.getAllCustomers();
    	for(Customer cust : customerList){
    	if(customer.getUserName().equals(cust.getUserName())){
    		model.addAttribute("userNameMsg","Username already exists");
    		return "registerCustomer";
    	}
    	if(customer.getEmail().equals(cust.getEmail())){
    		model.addAttribute("EmailMsg","Email already exists");
    		return "registerCustomer";
    	}
    	}
    	
    	customerService.addCustomer(customer);
    	return "registrationSuccess";
    }
    
    @RequestMapping("/about")
	public String about(){
		return "aboutUS";
	}
	
}
