package com.musicstore.DAO.Implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.DAO.orderDAO;
import com.musicstore.model.CustomerOrder;

@Repository
@Transactional
public class orderDAOImpl implements orderDAO{

    @Autowired
	private SessionFactory sessionFactory;
    
	@Override
	public void addCustomerOrder(CustomerOrder order) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
		session.flush();
		
	}
	

}
