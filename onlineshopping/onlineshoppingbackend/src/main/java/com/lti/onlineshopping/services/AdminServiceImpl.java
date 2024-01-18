package com.lti.onlineshopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;
import com.lti.onlineshopping.dao.AdminDao;
import com.lti.onlineshopping.exceptions.RetailerNotExistsException;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Retailer addRetailer(Retailer retailer) {
		Retailer retMsg = adminDao.addRetailer(retailer);
		return retMsg;
	}

	@Override
	public Retailer deleteRetailer(int retailerId) {

		Retailer retailer=null;
		try {
			retailer = adminDao.deleteRetailer(retailerId);

		} catch (RetailerNotExistsException e) {
			 System.out.println("Retailer with Id : " + retailerId + " does not exist");
		}
		return retailer;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = adminDao.getCustomerById(customerId);
		return customer;
	}

	@Override
	public Product getProductById(int productId) {
		Product product = adminDao.getProductById(productId);
		return product;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> productList = adminDao.getProducts();
		return productList;
	}

	@Override
	public List<Retailer> showRetailer() {
		List<Retailer> retailerList = adminDao.showRetailer();
		return retailerList;
	}

}
