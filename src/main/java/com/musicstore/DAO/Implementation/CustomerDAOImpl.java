package com.musicstore.DAO.Implementation;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.musicstore.DAO.customerDAO;
import com.musicstore.model.Authorities;
import com.musicstore.model.Cart;
import com.musicstore.model.Customer;
import com.musicstore.model.Users;

@Repository
@Transactional
public class CustomerDAOImpl implements customerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users users = new Users();
		users.setCustomerId(customer.getCustomerId());
		users.setUsername(customer.getUserName());
		users.setPassword(customer.getPassw());
		users.setEnabled(true);
		session.saveOrUpdate(users);
		
		Authorities authority = new Authorities();
		authority.setAuthority("ROLE_USER");
		authority.setUsername(customer.getUserName());
		session.saveOrUpdate(authority);
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(cart);
		
		session.flush();	
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
		session.flush();
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		session.flush();
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer)session.get(Customer.class,id);
		session.flush();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customer = session.createQuery("from Customer").list();
		session.flush();
		return customer;
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where userName = ?");
		query.setString(0,userName);
		session.flush();
		return (Customer)query.uniqueResult();
		
	}

	@Override
	public Long getCustomerIdByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select cust.customerId from Customer cust where cust.userName = :userName").setParameter("userName", userName);
		session.flush();
		return (Long)query.uniqueResult();
	}
    
	
}
