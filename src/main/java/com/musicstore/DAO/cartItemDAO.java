package com.musicstore.DAO;

import java.util.List;

import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;

public interface cartItemDAO {
	
	void addItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);
	CartItem getCartItemByProductId(Long productID, Long cartId);
	List<CartItem> getCartItemList(Long cartId);

}
