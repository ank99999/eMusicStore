package com.musicstore.DAO;

import java.io.IOException;

import com.musicstore.model.Cart;

public interface cartDAO {
	

	Cart getCartById(Long CartId);
	void addCart(Cart cart);
	Cart validate(Long CartId) throws IOException;
	void update(Cart cart);
	

}
