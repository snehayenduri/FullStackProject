package com.lti.onlineshopping.services;

import java.util.List;

import com.lti.onlineshopping.beans.Category;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;

public interface RetailerService {
	

	public abstract Retailer addRetailer(Retailer retailer);
	public abstract Retailer getRetailerById(int retailerId);
	public abstract Retailer deleteRetailer(int retailerId);
	
	
	////////////////////////
	
	public abstract Product addProduct(Product product);
	public abstract List<Product> showMyProducts(int retailerId);
	public abstract Product updateProduct(Product product) ;
	public abstract Product deleteProduct(int productId);
	
	public abstract Category getCategoryById(int categoryId);


}
