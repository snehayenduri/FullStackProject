package com.lti.onlineshopping.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.onlineshopping.beans.Cart;
import com.lti.onlineshopping.beans.CartTable;
import com.lti.onlineshopping.beans.Customer;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.exceptions.CartException;
import com.lti.onlineshopping.exceptions.ProductNotExistsException;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	////////////////////////////////////////////////////////// sneha part

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	public List<Customer> getCustomers() {

		String sql = "Select c from Customer c";
		Query qry = em.createQuery(sql);
		List<Customer> customerList = qry.getResultList();
		return customerList;
	}

	@Override
	@Transactional
	public String deleteCustomer(int customerId) {
		Customer customer = em.find(Customer.class, customerId);
		em.remove(customer);
		return "Account Deleted";
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = em.find(Customer.class, customerId);
		return customer;
	}

	/////////////////////////////////////////////////////////////////////// narmada
	/////////////////////////////////////////////////////////////////////// part
	@Override
	public Product getProductById(int prod_id) {
		// System.out.println("dao layer");
		Product prd = em.find(Product.class, prod_id);
		return prd;
	}

	@Override
	public Product getProductByName(String prod_name) {
		// System.out.println("dao layer");
		String sql = "Select p from Product p where productName=:prdname";
		Query qry = em.createQuery(sql);
		qry.setParameter("prdname", prod_name);
		Product prd = (Product) qry.getSingleResult();
		return prd;

	}

	@Override
	public List<Product> getProductByCategory(String category_name) {
		// System.out.println("dao layer");
		String sql = "Select p from Product p JOIN p.category c where c.categoryname=:cname";
		Query qry = em.createQuery(sql);
		qry.setParameter("cname", category_name);
		List<Product> prd = qry.getResultList();
		return prd;
	}

	@Override
	public List<Product> displayAllProducts() {
		System.out.println("dao layer");
		String sql = "Select p from Product p";
		Query qry = em.createQuery(sql);
		List<Product> prdList = qry.getResultList();
		return prdList;
	}

	@Override
	public List<Product> sortProductByName() {
		System.out.println("dao layer");
		String sql = "Select p from Product p order by productName";
		Query qry = em.createQuery(sql);
		List<Product> prdList = qry.getResultList();
		return prdList;

	}

	@Override
	public List<Product> sortProductByPriceAsc() {
		System.out.println("dao layer");
		String sql = "Select p from Product p order by productCost";
		Query qry = em.createQuery(sql);
		List<Product> prdList = qry.getResultList();
		return prdList;

	}

	@Override
	public List<Product> sortProductByPriceDesc() {
		System.out.println("dao layer");
		String sql = "Select p from Product p order by productCost DESC";
		Query qry = em.createQuery(sql);
		List<Product> prdList = qry.getResultList();
		return prdList;
	}
	
	////////////////////////////////////anish part
	@Override
	@Transactional
	public CartTable addToCart(int uId, int pId)    
	{
		Customer user = em.find(Customer.class, uId);
		Product product = em.find(Product.class, pId);
		
		CartTable cart = new CartTable();
		
		cart.setQuantity(1); //by default set qty as 1
		cart.setCustomer(user);
		cart.setProduct(product);
		this.em.persist(cart);
		return cart;
	}
	
	@Override
	@Transactional
	public boolean updateCart(int cartId, int addOrMinus)//updation by quantity
	{
		if(addOrMinus==1)//ADD
		{
			CartTable cart = em.find(CartTable.class, cartId);//find the cart
			int productQty = cart.getProduct().getQuantity();//get its actual/total product quantity from product table
			if(cart.getQuantity()+1 <= productQty) //check if updated or after addition cart quantity of an item should not exceed total item quantity 
			{
				//update it!
				int oldQty = cart.getQuantity(); 
				int newQty = oldQty+1;
				cart.setQuantity(newQty);
				em.merge(cart);
				return true;
			}
			return false;
		}
		else
		{    //subtract
			CartTable cart = em.find(CartTable.class, cartId);
			if(cart.getQuantity()-1 >= 1)//check if minium quantity of an item should be 1 ,while subtracting/removing item quantity it should not go below 1
			{
				//update it!
				int oldQty = cart.getQuantity();
				int newQty = oldQty-1;
				cart.setQuantity(newQty);
				em.merge(cart);
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean deleteCart(int cartId) throws CartException
	{
		CartTable cart = em.find(CartTable.class, cartId);//find the cart
		em.remove(cart);
		return true;
	}

	@Override
	public List<Cart> getCartValues(int userId) {
		
		int totalPrice = 0;
		List<Cart> carts = new ArrayList<Cart>();
		Customer user = (Customer)em.find(Customer.class, userId);
		System.out.println("User is :"+user);
		
		Query query = (Query)em.createQuery("Select c from CartTable c where customer=:x");
		query.setParameter("x", user);
		List<CartTable> cartTables = query.getResultList();
		
		//System.out.println("Cart values are :"+ cartTables[0].getProduct().getProductImage());
		
		
		for(CartTable c : cartTables)
		{
			int cartId = c.getCartId();
			int productId = c.getProduct().getProductId();
			int quantity = c.getProduct().getQuantity()>=c.getQuantity() ? c.getQuantity() : 0;
			String productName = c.getProduct().getProductName();
			String pBrand = c.getProduct().getProductBrand();
			int pPrice = c.getProduct().getProductCost();
			totalPrice += pPrice*quantity;
			String pImage1 = c.getProduct().getProductImage();
			carts.add(new Cart(productId,quantity,productName,pBrand,pPrice,cartId,totalPrice,pImage1));
			
		}
		return carts;
	
	}
	

}
