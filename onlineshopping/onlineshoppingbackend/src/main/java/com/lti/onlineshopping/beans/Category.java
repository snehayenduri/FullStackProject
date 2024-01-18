package com.lti.onlineshopping.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category {
	
	@Id
	@Column(name="CATEGORY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryname;

	public Category(int categoryId, String categoryname) {
		super();
		this.categoryId = categoryId;
		this.categoryname = categoryname;
	}

	public Category() {
		super();
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryname=" + categoryname + "]";
	}
	
	

}
