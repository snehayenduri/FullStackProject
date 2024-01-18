package com.lti.onlineshopping.services;

import java.util.List;

import com.lti.onlineshopping.beans.Cart;
import com.lti.onlineshopping.beans.CartTable;
import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.exceptions.CartException;
import com.lti.onlineshopping.exceptions.ProductNotExistsException;



public interface CustomerServices {
	
	
	//sneha part
	public abstract Customer addCustomer(Customer customer);
	public abstract String deleteCustomer(int customerId);
	public abstract Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	
	

	//narmada part
	public abstract Product getProductById(int prod_id);
	public abstract Product getProductByName(String prod_name);
	public abstract List<Product> getProductByCategory(String category_name);
	public abstract List<Product> displayAllProducts();
	public abstract List<Product> sortProductByName();
	public abstract List<Product> sortProductByPriceAsc();
	public abstract List<Product> sortProductByPriceDesc();
	
	
	////////////////////////////anishpart
	public CartTable addToCart(int uId, int pId);
	public List<Cart> getCartValues(int uId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId) throws CartException;
	


}
