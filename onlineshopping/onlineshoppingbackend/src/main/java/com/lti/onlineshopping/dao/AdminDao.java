package com.lti.onlineshopping.dao;

import java.util.List;

import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;
import com.lti.onlineshopping.exceptions.RetailerNotExistsException;

public interface AdminDao {
	
	public abstract Retailer addRetailer(Retailer retailer);
	public abstract Retailer deleteRetailer(int retailerId) throws RetailerNotExistsException;
	public abstract Customer getCustomerById(int customerId);
	public abstract Product getProductById(int productId);
	public List<Product> getProducts();
	public abstract List<Retailer> showRetailer();

}
