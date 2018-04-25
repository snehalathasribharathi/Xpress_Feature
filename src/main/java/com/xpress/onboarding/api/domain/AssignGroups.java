package com.xpress.onboarding.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AssignGroups implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5030988040942820561L;

	@Id
	private Integer assignGroupId;
	
	private Users users;
	private UserGroups userGroups;

	public Integer getAssignGroupId() {
		return assignGroupId;
	}

	public void setAssignGroupId(Integer assignGroupId) {
		this.assignGroupId = assignGroupId;
	}

	public AssignGroups() {
		super();
	}

	public AssignGroups(Integer assignGroupId,Users users, UserGroups userGroups) {
		super();
		this.assignGroupId = assignGroupId;
		this.users = users;
		this.userGroups = userGroups;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UserGroups getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(UserGroups userGroups) {
		this.userGroups = userGroups;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("USER GROUP ASSOCIATION ");
		stringBuilder.append("users").append(users).append(",");
		stringBuilder.append("userGroups").append(userGroups);
		return stringBuilder.toString();
	}

}
