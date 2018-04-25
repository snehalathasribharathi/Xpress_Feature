package com.xpress.onboarding.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contacts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1567505538626822435L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer contactId;
	@Column
	private String title;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String designation;
	@Column
	private String address;
	@Column
	private String emailId;
	@Column
	private Long contactNo;

	public Contacts() {
		super();
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("CONTACT DETAILS");
		stringBuilder.append("contactId").append(contactId);
		stringBuilder.append("title").append(title);
		stringBuilder.append("firstName").append(firstName);
		stringBuilder.append("lastName").append(lastName);
		stringBuilder.append("designation").append(designation);
		stringBuilder.append("address").append(address);
		stringBuilder.append("emailId").append(emailId);
		stringBuilder.append("contactNo").append(contactNo);
		return stringBuilder.toString();
	}
}
