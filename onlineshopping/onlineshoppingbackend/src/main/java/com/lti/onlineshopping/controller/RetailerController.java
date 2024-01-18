package com.lti.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.onlineshopping.beans.Category;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;
import com.lti.onlineshopping.services.RetailerServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/retailer")
public class RetailerController {

	@Autowired
	private RetailerServiceImpl retailerService;

	// http://localhost:8090/retailer/getRetailer/501
	@GetMapping("/getRetailer/{id}")
	public Retailer getRetailerById(@PathVariable("id") int retailerId) {
		return retailerService.getRetailerById(retailerId);
	}

	// http://localhost:8090/retailer/addRetailer
	@PostMapping("/addRetailer")
	public Retailer addRetailer(@RequestBody Retailer retailer) {
		Retailer retRetailer = retailerService.addRetailer(retailer);
		return retRetailer;
	}

	// http://localhost:8090/retailer/deleteRetailer/501
	@GetMapping("/deleteRetailer/{id}")
	public Retailer deleteRetailer(@PathVariable("id") int retailerId) {
		Retailer retailer = retailerService.deleteRetailer(retailerId);
		return retailer;
	}

	//////////////////////////

	// http://localhost:8090/retailer/addRetailerProduct
	@PostMapping(path = "/addRetailerProduct")
	public Product addRetailerProduct(@RequestBody Product product) {

		return retailerService.addProduct(product);
	}

	// http://localhost:8090/retailer/getRetailerProductsById/501
	@GetMapping(path = "/getRetailerProductsById/{retailerId}")
	public List<Product> getRetailerProductsBtId(@PathVariable int retailerId) {

		return retailerService.showMyProducts(retailerId);

	}

	// http://localhost:8090/retailer/updateProduct
	@PostMapping(path = "/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return retailerService.updateProduct(product);
	}

	// http://localhost:8090/retailer/deleteProduct/5001
	@DeleteMapping(path = "/deleteProduct/{productId}")
	public Product deleteproduct(@PathVariable int productId) {
		return retailerService.deleteProduct(productId);
	}
	
	//http://localhost:8084/retailer/getCategory/101
	@GetMapping("/getCategory/{id}")
	public Category getCategoryById(@PathVariable("id") int categoryId) {
		return retailerService.getCategoryById(categoryId);
	}

	

}
