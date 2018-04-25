package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import com.xpress.onboarding.api.domain.Company;

public interface ICompanyService {

	List<Company> getAllCompanies();

	Optional<Company> getCompanyById(Integer id);

	Company addCompany(Company company);

	Company updateCompany(int id, Company company);

	void deleteCompany(Integer id);

	void deleteAllCompanies();
}
