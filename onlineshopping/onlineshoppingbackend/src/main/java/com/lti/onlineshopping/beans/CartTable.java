package com.lti.onlineshopping.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CART")
public class CartTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cart_Sequence", sequenceName = "cart_Sequence", allocationSize = 1)
	@Column(name = "CART_ID")
	private int cartId;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "Total_Price", columnDefinition = "NUMBER", precision = 9, scale = 0)
	private int totalPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Product product;

	public CartTable() {
		super();
	}

	public CartTable(int cartId, int quantity, int totalPrice, Customer customer, Product product) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.product = product;
	}

	public CartTable(int quantity, int totalPrice, Customer customer, Product product) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.product = product;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartTable [cartId=" + cartId + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", customer="
				+ customer + ", product=" + product + "]";
	}
}
