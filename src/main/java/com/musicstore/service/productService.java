package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Product;

public interface productService {
	
	void addProduct(Product product);
	void deleteProduct(Long id);
	void updateProduct(Product product);
	Product getproductById(Long id);
	List<Product> getAllProducts();

}
