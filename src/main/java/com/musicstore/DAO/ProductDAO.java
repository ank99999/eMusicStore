package com.musicstore.DAO;



import java.util.List;

import com.musicstore.model.Product;

public interface ProductDAO {
	
	void addProduct(Product product);
	void deleteProduct(Long id);
	Product getProductById(Long id);
	List<Product> getAllProducts();
	void updateProduct(Product product);
	

}
