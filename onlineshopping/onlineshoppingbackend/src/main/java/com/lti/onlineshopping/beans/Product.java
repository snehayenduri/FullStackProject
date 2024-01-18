package com.lti.onlineshopping.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_sequence")
	@SequenceGenerator(name="products_sequence",sequenceName="products_sequence",allocationSize = 1)
	private int productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_COST")
	private int productCost;
	
	@Column(name="QUANTITY")
	private int quantity;
	

	@Column(name="PRODUCT_IMAGE")
	private String productImage;
	
	@Column(name="PRODUCT_BRAND")
	private String productBrand;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RETAILER_ID")
	private Retailer retailer;

	public Product(int productId, String productName, int productCost, int quantity, String productImage,
			String productBrand, Category category, Retailer retailer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.quantity = quantity;
		this.productImage = productImage;
		this.productBrand = productBrand;
		this.category = category;
		this.retailer = retailer;
	}

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", quantity=" + quantity + ", productImage=" + productImage + ", productBrand=" + productBrand
				+ ", category=" + category + ", retailer=" + retailer + "]";
	}
	

	
	

	
	
	

}
