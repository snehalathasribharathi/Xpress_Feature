package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import com.xpress.onboarding.api.domain.Accounts;

public interface IAccountService {

	List<Accounts> getAllAccounts();

	Optional<Accounts> getAccountsById(Integer id);

	Accounts addAccounts(Accounts accounts);

	Accounts updateAccounts(int id, Accounts accounts);

	void deleteAccounts(Integer id);

	void deleteAllAccounts();
}
