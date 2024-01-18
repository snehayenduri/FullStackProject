package com.lti.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lti.onlineshopping.beans.Cart;
import com.lti.onlineshopping.beans.CartTable;
import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;

import com.lti.onlineshopping.services.CustomerServicesImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServicesImpl customerService;

	// http://localhost:8090/customer/getCustomers
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerService.getCustomers();
		return customerList;

	}

	// http://localhost:8090/customer/getCustomer/1001
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable("id") int customerId) {
		return customerService.getCustomerById(customerId);
	}

	// http://localhost:8090/customer/addCustomer
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer retCustomer = customerService.addCustomer(customer);
		return retCustomer;
	}

	// http://localhost:8090/customer/deleteCustomer/1001
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int customerId) {
		return customerService.deleteCustomer(customerId);
	}

	///////////////////////////////////////////////////////////// narmada part

	// http:localhost:8090/customer/allProducts
	@GetMapping("/allProducts")
	public List<Product> getProductList() {
		List<Product> prdList = customerService.displayAllProducts();
		System.out.println(prdList);
		return prdList;
	}

	// http:localhost:8090/customer/products/5000
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") int prod_id) {
		return customerService.getProductById(prod_id);
	}

	// http:localhost:8090/Customer/products/byName/cap
	@GetMapping("/products/byName/{id}")
	public Product getProductByName(@PathVariable(value = "id") String prod_name) {
		return customerService.getProductByName(prod_name);
	}

	// http:localhost:8090/Customer/products/byCategory/Mobiles
	@GetMapping("/products/byCategory/{id}")
	public List<Product> getProductBycategory(@PathVariable(value = "id") String category_name) {
		return customerService.getProductByCategory(category_name);
	}

	// http://localhost:8090/Customer/products/sortByName
	@GetMapping("/products/sortByName")
	public List<Product> getSortByNameProd() {
		List<Product> prdList = customerService.sortProductByName();
		System.out.println(prdList);
		return prdList;
	}

	// http://localhost:8090/customer/products/sortByCost/lowToHigh
	@GetMapping("/products/sortByCost/lowToHigh")
	public List<Product> getSortByPrice() {
		List<Product> prdList = customerService.sortProductByPriceAsc();
		System.out.println(prdList);
		return prdList;
	}

	// http://localhost:8090/Customer/products/sortByCost/highToLow
	@GetMapping("/products/sortByCost/highToLow")
	public List<Product> getSortByPriceDesc() {
		List<Product> prdList = customerService.sortProductByPriceDesc();
		System.out.println(prdList);
		return prdList;
	}

	////////////////////////////////////////////////////////////////// anish part

	// 1. See All Products inside Carts

	// http://localhost:8090/customer/cart/getMyCart/1001
	@GetMapping(path = "cart/getMyCart/{uId}") // passed
	public List<Cart> getMyCart(@PathVariable int uId) {
		return this.customerService.getCartValues(uId);
	}

//			2. ADD PRODUCT TO CART OF A USER:---

	// http://localhost:8090/customer/cart/addToMyCart/1001/5001

	@GetMapping(path = "cart/addToMyCart/{uId}/{pId}") // passed
	public CartTable addToMyCart(@PathVariable int uId, @PathVariable int pId) {
		CartTable cart = customerService.addToCart(uId, pId);
		return cart;
	}

//			3. UPDATE CART BY ADDING OR SUBTRACTING A PRODUCT FROM IT :-----

//			BY DEFAULT MIN PRODUCT AVAILABLE SHOULD BE 1
//			PRODUCT QUANTITY in cart should not exceed actual product quantity in product table

	// http://localhost:8090/customer/cart/updateMyCart/1001/
	@GetMapping(path = "cart/updateMyCart/{cId}/{addOrMinus}") // passed
	public String updateMyCart(@PathVariable String cId, @PathVariable String addOrMinus) {
		boolean ok = this.customerService.updateCart(Integer.parseInt(cId), Integer.parseInt(addOrMinus));
		if (ok == true)
			return "Cart Updated Successfull";
		return "Cannot Update Cart";
	}
	
	//http://localhost:8090/customer/cart/deleteMyCart/61
	@DeleteMapping(path = "cart/deleteMyCart/{cId}")//passed
	public String deleteMyCart(@PathVariable int cId) {
		try {
			boolean oK = customerService.deleteCart(cId);
			return "deleted succesfully";

		} catch (Exception e) {
			return "not found";
		}
	}

}
