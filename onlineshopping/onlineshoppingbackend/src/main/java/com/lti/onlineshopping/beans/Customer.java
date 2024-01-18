package com.lti.onlineshopping.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_sequence")
	@SequenceGenerator(name="customer_sequence", sequenceName="customer_sequence",allocationSize=1)
	@Column(name="CUSTOMER_ID")
	private int customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DOOR_NO")
	private String doorNo;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="PINCODE")
	private int pincode;
	
	@Column(name="MOBILE_NUMBER")
	private long mobileNumber;
	
	
	public Customer() {
		super();
	}


	public Customer(String customerName, String password, String emailAddress, String doorNo, String street, String city,
			String state, String country, int pincode, long mobileNumber) {
		super();
		this.customerName = customerName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailAddres() {
		return emailAddress;
	}


	public void setEmailAddres(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getDoorNo() {
		return doorNo;
	}


	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", emailAddress=" + emailAddress + ", doorNo=" + doorNo + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
}
