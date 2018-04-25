package com.xpress.onboarding.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5234918913521397797L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long userId;
	private String userName;
	private String address;
	private String email;
	private String contactNo;
	private String designation;
	private String company;

	public Users() {
		super();
	}

	public Users(Long i, String userName, String address, String email, String contactNo, String designation,
			String company) {
		super();
		this.userId = i;
		this.userName = userName;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.designation = designation;
		this.company = company;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("USER DETAILS");
		stringBuilder.append("userId").append(userId).append(",");
		stringBuilder.append("userName").append(userName).append(",");
		stringBuilder.append("address").append(address).append(",");
		stringBuilder.append("email").append(email).append(",");
		stringBuilder.append("contactNo").append(contactNo).append(",");
		stringBuilder.append("designation").append(designation).append(",");
		stringBuilder.append("company").append(company);
		return stringBuilder.toString();
	}

}
