package com.musicstore.DAO.Implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.DAO.cartItemDAO;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
@Repository
@Transactional
@Component("CartItemDAOImpl")
public class CartItemDAOImpl implements cartItemDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();	
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> listCartItems = cart.getListCartItems();
		Session session = sessionFactory.getCurrentSession();
		for(CartItem cartItem : listCartItems){
			session.delete(cartItem);
		}
		session.flush();
	}

	@Override
	public CartItem getCartItemByProductId(Long productID, Long cartId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productID = ? and cartId = ?");
		query.setLong(0,productID);
		query.setLong(1,cartId);
		session.flush();
		return (CartItem)query.uniqueResult();
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CartItem> getCartItemList(Long cartId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where cartId= ?");
		query.setLong(0,cartId);
		session.flush();
		return query.list();
		
	}
	
	

}
