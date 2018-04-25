package com.xpress.onboarding.api.services;

import java.util.List;

import com.xpress.onboarding.api.domain.UserGroups;
import com.xpress.onboarding.api.domain.Users;

public interface IUserGroupService {

	List<Users> getAllUsers();

	List<UserGroups> getAllUserGroups();

	String assignUsersToGroups();

}
