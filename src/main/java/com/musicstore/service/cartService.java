package com.musicstore.service;

import com.musicstore.model.Cart;

public interface cartService {
	
	Cart getCartById(Long cartId);
	Cart getCartByCustomerId(Long customerId);
	void addCart(Cart cart);

}
