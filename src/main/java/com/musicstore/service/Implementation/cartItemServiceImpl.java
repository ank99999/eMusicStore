package com.musicstore.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.service.cartItemService;
import com.musicstore.DAO.cartItemDAO;

@Service
public class cartItemServiceImpl implements cartItemService{
    
	@Autowired
	private cartItemDAO cartItemDAO;

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDAO.addItem(cartItem);
		
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDAO.removeCartItem(cartItem);
		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDAO.removeAllCartItems(cart);
		
	}

	@Override
	public CartItem getCartItemByProductId(Long productID , Long cartId) {
		return cartItemDAO.getCartItemByProductId(productID, cartId);
		
	}

	@Override
	public List<CartItem> getCartItemList(Long cartId) {
		return cartItemDAO.getCartItemList(cartId);
	}
	
	
	
	
}
