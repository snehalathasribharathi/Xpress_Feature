package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpress.onboarding.api.dao.AccountsRepository;
import com.xpress.onboarding.api.domain.Accounts;
import com.xpress.onboarding.api.domain.Company;


@Service
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	AccountsRepository accountsDao;

	public List<Accounts> getAllAccounts() {
		logger.info("inside Account Service.getAllAccounts");
		return (List<Accounts>) accountsDao.findAll();
	}

	public Optional<Accounts> getAccountsById(Integer id) {
		logger.info("Getting Accounts details for ID " + id);
		return accountsDao.findById(id);
	}

	public Accounts addAccoounts(Accounts accounts ) {
		logger.info("Adding Accounts " + accounts);
		return accountsDao.save(accounts);
	}

	public Accounts updateAccounts(int id, Accounts accounts ) {
		logger.info("Updating Accounts for ID " + accounts);
		 Accounts updatedaccounts=null;
	        if(id== accounts.getAccountId()) {
	        	updatedaccounts=accountsDao.save(accounts);
	        }
	        return updatedaccounts;
	}

	public void deleteAccounts(Integer id) {
		logger.info("Deleting Accounts for ID " + id);
		accountsDao.deleteById(id);
	}

	public void deleteAllAccounts() {
		logger.info("Deleting all accounts ");
		accountsDao.deleteAll();
	}
}
