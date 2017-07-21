package com.musicstore.service;

import java.util.List;

import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;

public interface cartItemService {
	
	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);
	CartItem getCartItemByProductId(Long productID , Long cartId);
	List<CartItem> getCartItemList(Long cartId);

}
