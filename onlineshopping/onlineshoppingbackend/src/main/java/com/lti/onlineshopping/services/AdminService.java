package com.lti.onlineshopping.services;

import java.util.List;

import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;

public interface AdminService {
	

	public abstract Retailer addRetailer(Retailer retailer);
	public abstract Retailer deleteRetailer(int retailerId);
	public abstract Customer getCustomerById(int customerId);
	public abstract Product getProductById(int productId);
	public List<Product> getProducts();
	public abstract List<Retailer> showRetailer();

}
