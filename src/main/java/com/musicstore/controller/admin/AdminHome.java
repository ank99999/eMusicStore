package com.musicstore.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicstore.model.Product;
import com.musicstore.service.productService;;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	private productService productService;
	
	@RequestMapping
	public String adminHome(){
	   return "admin";
   }
	
	@RequestMapping("/productInventory")
    public String viewList(Model model){	
	List<Product> listOfProducts = productService.getAllProducts();
	model.addAttribute("listOfProducts", listOfProducts);
	return "productInventory";	
	}
	
	
}
