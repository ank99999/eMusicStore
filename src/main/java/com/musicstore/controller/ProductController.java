package com.musicstore.controller;

import com.musicstore.model.Product;
import com.musicstore.service.productService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private productService productService;
	
	@RequestMapping("/productList/All")
	public String viewProductList(Model model){
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		return "productList";
	}
	
	
	@RequestMapping(value = "/viewProduct/{id}")
	public String viewProduct(@PathVariable(value = "id")String id, Model model){
		Product product = productService.getproductById(Long.parseLong(id));
		model.addAttribute("product",product);
		return "ProductDetail";
	}
	
	@RequestMapping(value = "/productList")
	public String getAllProductsByCategory(@RequestParam("searchCondition") String searchCondition , Model model){
		
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		model.addAttribute("searchCondition",searchCondition);
		return "productList";
		
		
	}

}
