package com.xpress.onboarding.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpress.onboarding.api.domain.UserGroups;
import com.xpress.onboarding.api.domain.Users;
import com.xpress.onboarding.api.services.IUserGroupService;

@RestController
@RequestMapping("/onboarding")
public class UsersAssociationController {

	@Autowired
	IUserGroupService userGroupService;

	@GetMapping(value = "/users")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = userGroupService.getAllUsers();
		if (users.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);

	}

	@GetMapping(value = "/usergroups")
	public ResponseEntity<List<UserGroups>> getAllUserGroups() {
		List<UserGroups> userGroups = userGroupService.getAllUserGroups();
		if (userGroups.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserGroups>>(userGroups, HttpStatus.OK);
	}

	@PostMapping(value = "/assignUsers")
	public String assignUsersToGroups(@RequestBody Users i) {
		return userGroupService.assignUsersToGroups();
	}
}
