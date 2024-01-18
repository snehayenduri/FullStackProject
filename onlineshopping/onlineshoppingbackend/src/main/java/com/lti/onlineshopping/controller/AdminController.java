package com.lti.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;
import com.lti.onlineshopping.services.AdminServiceImpl;
import com.lti.onlineshopping.services.CustomerServicesImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/retailer")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;

	// http://localhost:8100/hr/admin/getCustomer/1001
	@GetMapping("/admin/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable("id") int customerId) {
		return adminService.getCustomerById(customerId);
	}

	// http://localhost:8100/hr/admin/addRetailer
	@PostMapping("/admin/addRetailer")
	public Retailer addRetailer(@RequestBody Retailer retailer) {
		Retailer e = adminService.addRetailer(retailer);
		return e;
	}

	// http://localhost:8100/hr/admin/deleteRetailer/501
	@GetMapping("/admin/deleteRetailer/{id}")
	public Retailer deleteRetailer(@PathVariable("id") int retailerId) {
		return adminService.deleteRetailer(retailerId);
	}

	// http://localhost:8100/hr/admin/getproducts
	@GetMapping("/admin/getproducts")
	public List<Product> getProducts() {
		List<Product> productList = adminService.getProducts();
		return productList;

	}

	// http://localhost:8100/hr/admin/getProductById/5001
	@GetMapping("/admin/getProductById/{id}")
	public Product getProductById(@PathVariable("id") int productId) {
		return adminService.getProductById(productId);
	}

	@GetMapping("/admin/showAllRetailers")
	public List<Retailer> showAllRetailers() {
		List<Retailer> retailerList = adminService.showRetailer();
		return retailerList;

	}

}
