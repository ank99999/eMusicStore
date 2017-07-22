package com.musicstore.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.musicstore.model.Product;
import com.musicstore.service.productService;;

@Controller
@RequestMapping("/admin/product")
public class AdminProduct {
    @Autowired
	private productService productService;
	private Path path;
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct", method= RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product p,BindingResult result , HttpServletRequest request){
	  
		if (result.hasErrors()){
			return "addProduct";
		}
		
		MultipartFile productImage = p.getProductImage();
		
		  productService.addProduct(p);	
		  String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		  path = Paths.get(rootDirectory+"\\resources\\images\\"+p.getProductID()+".png");		 
		 if(productImage != null && !productImage.isEmpty()){
			 
			try {
				productImage.transferTo(new File(path.toString()));
			 }catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product Image saving failed");
			} 
		 }
		 return "redirect:/admin/productInventory";
		
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id")String id, HttpServletRequest request){
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+id+".png"); 
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		productService.deleteProduct(Long.parseLong(id));
		return "redirect:/admin/productInventory";
		
	}
	
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable(value = "id") String id,Model model){
		Product product = productService.getproductById(Long.parseLong(id));
		if(product.equals(null)){
			System.out.println("---------------------------------------------");
			System.out.println("product empty");
		}
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@RequestMapping(value = "/updateProduct" , method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product,BindingResult result){
		
		if(result.hasErrors()){
			return "updateProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		path = Paths.get("C:/Users/Ankita/workspace/eMusicStore/src/main/webapp/WEB-INF/resources/images/"+product.getProductID()+".png");
		if(productImage != null && !productImage.isEmpty()){
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product Image Saving Failed");
			}
		}
		
		productService.updateProduct(product);
		return "redirect:/admin/productInventory";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
