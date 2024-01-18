package com.lti.onlineshopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.onlineshopping.beans.Category;
import com.lti.onlineshopping.beans.Product;
import com.lti.onlineshopping.beans.Retailer;

@Repository
public class RetailerDaoImpl implements RetailerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Retailer getRetailerById(int retailerId) {
		Retailer retailer = em.find(Retailer.class, retailerId);
		return retailer;
	}

	@Override
	@Transactional
	public Retailer addRetailer(Retailer retailer) {
		em.persist(retailer);
		return retailer;
	}

	@Override
	@Transactional
	public Retailer deleteRetailer(int retailerId) {
		Retailer retailer = em.find(Retailer.class, retailerId);
		if (retailer == null) {
			return null;
		}
		em.remove(retailer);
		return retailer;
	}

	@Override
	@Transactional
	public Product addProduct(Product product) {
		em.persist(product);
		return product;
	}

	@Override
	public List<Product> showMyProducts(int retailerId) {
		Retailer retailer = em.find(Retailer.class, retailerId);
		Query query = (Query) em.createQuery("Select p from Product p where retailer=:x");
		query.setParameter("x", retailer);
		List<Product> productList = query.getResultList();
		return productList;
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		Product prd = em.find(Product.class, product.getProductId());
		prd.setProductBrand(product.getProductBrand());
		prd.setProductCost(product.getProductCost());
		prd.setProductName(product.getProductName());
		prd.setProductImage(product.getProductImage());
		prd.setQuantity(product.getQuantity());
		prd.setCategory(product.getCategory());

		em.merge(prd);
		return product;
	}

	@Override
	@Transactional
	public Product deleteProduct(int productId) {
		Product product = em.find(Product.class, productId);
		em.remove(product);
		return product;

	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category category = em.find(Category.class, categoryId);
		return category;
	}
}
