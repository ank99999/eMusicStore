package com.musicstore.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.DAO.ProductDAO;
import com.musicstore.model.Product;
import com.musicstore.service.productService;

@Service
public class productServiceImplementation implements productService{
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void addProduct(Product product) {
	      
		productDAO.addProduct(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		
		productDAO.deleteProduct(id);
		
	}

	@Override
	public void updateProduct(Product product) {
		
		productDAO.updateProduct(product);
		
	}

	@Override
	public Product getproductById(Long id) {
		
		return productDAO.getProductById(id);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	
	

}
