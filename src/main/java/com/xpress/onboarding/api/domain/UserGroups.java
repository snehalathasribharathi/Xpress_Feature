package com.xpress.onboarding.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserGroups implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3760881740478930150L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userGroupId;
	private String userGroupName;
	private String companyName;

	public UserGroups() {
		super();

	}

	public UserGroups(int userGroupId, String userGroupName, String companyName) {
		super();
		this.userGroupId = userGroupId;
		this.userGroupName = userGroupName;
		this.companyName = companyName;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("USERGROUP DETAILS");
		stringBuilder.append("userGroupId").append(userGroupId).append(",");
		stringBuilder.append("userGroupName").append(userGroupName).append(",");
		stringBuilder.append("companyName").append(companyName);
		return stringBuilder.toString();
	}

}
