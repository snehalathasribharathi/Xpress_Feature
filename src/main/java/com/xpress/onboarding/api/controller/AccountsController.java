package com.xpress.onboarding.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpress.onboarding.api.domain.Accounts;
import com.xpress.onboarding.api.exceptions.CustomErrorType;
import com.xpress.onboarding.api.services.AccountService;

@RestController
@RequestMapping("/onboarding")
public class AccountsController {

	private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

	@Autowired
	AccountService accountService;

	/*
	 * @GetMapping("/hello") public String hello() { return "Hi"; }
	 */
	@GetMapping(value = "/accounts")
	public ResponseEntity<List<Accounts>> getAllAccounts() {
		List<Accounts> accounts = accountService.getAllAccounts();
		if (accounts.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}

	@GetMapping(value = "/accounts/{id}")
	public ResponseEntity<Optional<Accounts>> getAccountsById(@PathVariable("id") final Integer accountsId) {
		Optional<Accounts> accounts = accountService.getAccountsById(accountsId);
		return ResponseEntity.ok().body(accounts);
	}

	@PostMapping(value = "/accounts")
	public ResponseEntity<String> addAccounts(@RequestBody final Accounts accounts) {
		Accounts savedAccounts = accountService.addAccoounts(accounts);
		return ResponseEntity.ok().body("New Account has been saved with ID: " + savedAccounts.getAccountId());
	}

	@PutMapping(value = "/accounts/{id}")
	public ResponseEntity<String> updateAccounts(@RequestBody final Accounts accounts,
			@PathVariable("id") Integer accountsId) {
		accountService.updateAccounts(accountsId, accounts);
		return ResponseEntity.ok().body("Accounts has been updated successfully with the account ID " + accountsId);
	}

	@DeleteMapping(value = "/accounts/{id}")
	public ResponseEntity<?> deleteAccounts(@PathVariable("id") Integer accountId) {
		logger.info("Deleting the accounts for the ID" + accountId);
		Optional<Accounts> accounts = accountService.getAccountsById(accountId);
		if (!accounts.isPresent()) {
			logger.error("Unable to delete the accounts with id {}", accountId);
			CustomErrorType error = new CustomErrorType(
					"Unable to delete the accounts with id " + accountId + " not found.");
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		}
		accountService.deleteAccounts(accountId);
		// return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("Account has been deleted successfully for the ID: " + accountId);
	}

	@DeleteMapping(value = "/accounts")
	public ResponseEntity<String> deleteAllAccounts() {
		logger.info("Deleting All Accounts");
		accountService.deleteAllAccounts();
		// return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("All Accounts have been deleted successfully");
	}
}
