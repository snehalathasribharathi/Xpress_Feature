package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpress.onboarding.api.dao.CompanyRepository;
import com.xpress.onboarding.api.domain.Accounts;
import com.xpress.onboarding.api.domain.Company;

@Service
public class CompanyServiceImpl implements ICompanyService {

	private static final Logger logger=LoggerFactory.getLogger(CompanyServiceImpl.class);
	
	@Autowired
	CompanyRepository companyDao;
	
	public List<Company> getAllCompanies() {
        logger.info("inside CompanyService.getAllCompanies");
        return (List<Company>) companyDao.findAll();
    }
 
    public Optional<Company> getCompanyById(Integer id) {
        logger.info("Getting Company details for ID " + id);
        return companyDao.findById(id);
    }
 
    public Company addCompany(Company company) {
        logger.info("Adding Company " + company);
        return companyDao.save(company);
    }
 
    public Company updateCompany(int id,Company company) {
        logger.info("Updating Company for ID " + company);
        Company updatedcompany=null;
        if(id== company.getCompanyId()) {
        updatedcompany=companyDao.save(company);
        }
        return updatedcompany;
    }
 
    public void deleteCompany(Integer id) {
        logger.info("Deleting company for ID " + id);
        companyDao.deleteById(id);
    }
 
        public void deleteAllCompanies() {
    	logger.info("Deleting all companies " );
    	companyDao.deleteAll();
    }

}
