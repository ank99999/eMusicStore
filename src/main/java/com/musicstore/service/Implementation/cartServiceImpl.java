package com.musicstore.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.model.Cart;
import com.musicstore.service.cartService;
import com.musicstore.DAO.cartDAO;

@Service
public class cartServiceImpl implements cartService{
	@Autowired
	private cartDAO cartDAO;

	@Override
	public Cart getCartById(Long cartId) {
		
		return cartDAO.getCartById(cartId);
	}

	@Override
	public Cart getCartByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCart(Cart cart) {
		cartDAO.addCart(cart);
		
	}


	

}
