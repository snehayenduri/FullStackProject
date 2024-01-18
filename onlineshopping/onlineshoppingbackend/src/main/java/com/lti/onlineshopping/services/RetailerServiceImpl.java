package com.lti.onlineshopping.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.onlineshopping.beans.Category;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;
import com.lti.onlineshopping.dao.RetailerDao;

@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	private RetailerDao retailerDao;

	public RetailerDao getRetailerDao() {
		return retailerDao;
	}

	public void setRetailerDao(RetailerDao retailerDao) {
		this.retailerDao = retailerDao;
	}

	@Override
	public Retailer getRetailerById(int retailerId) {
		Retailer retailer = retailerDao.getRetailerById(retailerId);
		return retailer;
	}

	@Override
	public Retailer addRetailer(Retailer retailer) {
		Retailer retRetailer = retailerDao.addRetailer(retailer);
		return retRetailer;
	}

	@Override
	public Retailer deleteRetailer(int retailerId) {
		return retailerDao.deleteRetailer(retailerId);
	}

	@Override
	public Product addProduct(Product product) {

		return retailerDao.addProduct(product);

	}

	@Override
	public List<Product> showMyProducts(int retailerId) {

		return retailerDao.showMyProducts(retailerId);
	}

	@Override
	public Product updateProduct(Product product) {

		return retailerDao.updateProduct(product);
	}

	@Override
	public Product deleteProduct(int productId) {
		return retailerDao.deleteProduct(productId);
	}

	@Override
	public Category getCategoryById(int categoryId) {
	
		return retailerDao.getCategoryById(categoryId);
	}

}
