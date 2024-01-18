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
@Table(name="RETAILERS")
public class Retailer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="retailer_sequence")
	@SequenceGenerator(name="retailer_sequence",sequenceName="retailer_sequence",allocationSize = 1)
	@Column(name="RETAILER_ID")
	private int retailerId;
	
	@Column(name="RETAILER_NAME")
	private String retailerName;
	
	@Column(name="EMAIL")
	private String emailId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ADMIN_ID")
	private Admin admin;

	@Column(name="MOBILE_NUMBER")
	private long mobileNumber;

	
	@Column(name="PASSWORD")
	private String password;
	
		
	
	public Retailer(int retailerId, String retailerName, String emailId, String password, int mobileNumber,
			Admin admin) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.admin = admin;
	}

	public Retailer() {
		super();
	}

	public int getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", emailId=" + emailId
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", admin=" + admin + "]";
	}
	
	

	
	
	
	
}
