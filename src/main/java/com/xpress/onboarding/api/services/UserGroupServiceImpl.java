package com.xpress.onboarding.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpress.onboarding.api.dao.UserRepository;
import com.xpress.onboarding.api.domain.UserGroups;
import com.xpress.onboarding.api.domain.Users;

/* Yet to complete the code*/
@Service
public class UserGroupServiceImpl implements IUserGroupService {

	/*@Autowired
	UserRepository userDao;*/

	List<Users> users = new ArrayList<Users>(
			Arrays.asList(
					new Users(new Long(1), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(2), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(3), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(4), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(5), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(6), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(7), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(8), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(9), "Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG"),
					new Users(new Long(10),"Ram", "Bangalore", "ram@sg.com", "9090909090", "Manager", "SG")
					));
	
	List<UserGroups> userGroups=new ArrayList<UserGroups>(
			Arrays.asList(
					new UserGroups(1,"JPMC_OPER_TEAM","JPMC"),
					new UserGroups(2,"JPMC_SALES_TEAM","JPMC"),
					new UserGroups(3,"JPMC_ADMIN_TEAM","JPMC"),
					new UserGroups(4,"SG_OPER_TEAM","SG"),
					new UserGroups(5,"SG_SALES_TEAM","SG"),
					new UserGroups(6,"SG_ADMIN_TEAM","SG"),
					new UserGroups(7,"THALES_OPER_TEAM","THALES"),
					new UserGroups(8,"THALES_SALES_TEAM","THALES"),
					new UserGroups(9,"THALES_ADMIN_TEAM","THALES")				
					));
						
	@Override
	public List<Users> getAllUsers() {
		return users;
	}

	@Override
	public List<UserGroups> getAllUserGroups() {
		return userGroups;
	}
	
	
	
	@Override
	public String assignUsersToGroups() {
		return null;
	}

}
