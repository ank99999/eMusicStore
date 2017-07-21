package com.musicstore.DAO.Implementation;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.DAO.cartDAO;
import com.musicstore.model.Cart;
import com.musicstore.service.orderService;

@Repository
@Transactional
@Component("CartDAOImpl")
public class CartDAOImpl implements cartDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private orderService orderservice;

	

	@Override
	public Cart getCartById(Long CartId) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = (Cart)session.get(Cart.class, CartId);
		session.flush();
		return cart;
	}
	
	
	@Override
	public void update(Cart cart) {
        long cartId = cart.getCartId();
        double grandTotal = orderservice.orderTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }



	@Override
	public Cart validate(Long CartId) throws IOException {
		//Session session = sessionFactory.getCurrentSession();
		Cart cart = getCartById(CartId);
		if(cart==null||cart.getListCartItems().size()== 0){
			throw new IOException(CartId+"");
		}
		update(cart);
		return cart;
	}



	@Override
	public void addCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		session.flush();
		
	}
	
	
	
	
	

}
