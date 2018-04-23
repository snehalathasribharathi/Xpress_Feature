package com.xpress.onboarding.api.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1622828039902638564L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	@Column
	private String accountName;
	@Column
	private String accountType;
	@Column
	private String accountNumber;

	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("ACCOUNT DETAILS");
		stringBuilder.append("accountId").append(accountId);
		stringBuilder.append("accountName").append(accountName);
		stringBuilder.append("accountType").append(accountType);
		stringBuilder.append("accountNumber").append(accountNumber);
		return stringBuilder.toString();
	}
}
