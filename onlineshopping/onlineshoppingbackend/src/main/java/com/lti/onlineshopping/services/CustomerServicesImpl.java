package com.lti.onlineshopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.onlineshopping.beans.Cart;
import com.lti.onlineshopping.beans.CartTable;
import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.dao.CustomerDao;
import com.lti.onlineshopping.exceptions.CartException;


@Service("custService")
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	//////////////////////////////////////////////////// sneha part
	@Override
	public Customer addCustomer(Customer customer) {
		Customer retCustomer = customerDao.addCustomer(customer);
		return retCustomer;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerDao.getCustomers();
		return customerList;
	}

	@Override
	public String deleteCustomer(int customerId) {
		String retMsg = customerDao.deleteCustomer(customerId);
		return retMsg;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = customerDao.getCustomerById(customerId);
		return customer;
	}

	////////////////////////////////////////////////// narmada part

	@Override
	public Product getProductById(int prod_id) {
		Product prd = customerDao.getProductById(prod_id);
		return prd;

	}

	@Override
	public Product getProductByName(String prod_name) {
		System.out.println("service layer");
		Product prd = customerDao.getProductByName(prod_name);
		return prd;
	}

	@Override
	public List<Product> getProductByCategory(String category_name) {
		System.out.println("service layer");
		List<Product> prd = customerDao.getProductByCategory(category_name);
		return prd;
	}

	@Override
	public List<Product> displayAllProducts() {
		System.out.println("service layer");
		List<Product> prdList = customerDao.displayAllProducts();
		return prdList;
	}

	@Override
	public List<Product> sortProductByName() {
		System.out.println("service layer");
		List<Product> prdList = customerDao.sortProductByName();
		return prdList;
	}

	@Override
	public List<Product> sortProductByPriceAsc() {
		System.out.println("service layer");
		List<Product> prdList = customerDao.sortProductByPriceAsc();
		return prdList;

	}

	@Override
	public List<Product> sortProductByPriceDesc() {
		System.out.println("service layer");
		List<Product> prdList = customerDao.sortProductByPriceDesc();
		return prdList;
	}

	//////////////////////////////////////// anish part

	@Override
	public CartTable addToCart(int uId, int pId) {

		return this.customerDao.addToCart(uId, pId);
	}

	@Override
	public boolean updateCart(int cId, int addOrMinus) {

		return this.customerDao.updateCart(cId, addOrMinus);
	}

	@Override
	public boolean deleteCart(int cId) throws CartException {

		return this.customerDao.deleteCart(cId);
	}

	@Override
	public List<Cart> getCartValues(int uId) {

		return customerDao.getCartValues(uId);
	}

}
