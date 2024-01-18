package com.lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;
import com.lti.onlineshopping.exceptions.RetailerNotExistsException;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
	

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Retailer addRetailer(Retailer retailer){
		
		em.merge(retailer);
		return retailer;	
	}

	@Override
	@Transactional
	public Retailer deleteRetailer(int retailerId) throws RetailerNotExistsException {
		Retailer retailer = em.find(Retailer.class, retailerId);
		if(retailer==null) {
			throw new RetailerNotExistsException();
		}
		
		em.remove(retailer);
		return retailer;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = em.find(Customer.class, customerId);
		return customer;
	}

	
	@Override
	public Product getProductById(int productId) {
		Product product = em.find(Product.class, productId);
		return product;
	}

	public List<Product> getProducts() {

		String sql = "Select p from Product p";
		Query qry = em.createQuery(sql);
		List<Product> productList = qry.getResultList();
		return productList;
	}

	@Override
	public List<Retailer> showRetailer() {
		List<Retailer> retailerList=em.createQuery("Select r from Retailer r").getResultList();
		return retailerList;
	}

}
