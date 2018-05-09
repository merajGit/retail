package com.store.retail.model;

import java.util.Date;

public class Customer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String birthday;
	private Date dOb;
	private Enum customerType;
	private String addresses;
	private String phoneNumber;
	private String email;
	private String gender;
	private Date registrationDate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Date getdOb() {
		return dOb;
	}

	public void setdOb(Date dOb) {
		this.dOb = dOb;
	}

	public Enum getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Enum customerType) {
		this.customerType = customerType;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

}
