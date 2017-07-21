package com.musicstore.DAO.Implementation;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.musicstore.DAO.ProductDAO;
import com.musicstore.model.Product;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	
	@Override
	public void deleteProduct(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = getProductById(id);
		session.delete(product);
		session.flush();
	}

	
	@Override
	public Product getProductById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class,id);
		session.flush();
		
		return product;
	}

	
	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		return products;
	}

	
	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	
	

}
