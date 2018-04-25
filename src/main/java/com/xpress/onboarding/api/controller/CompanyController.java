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

import com.xpress.onboarding.api.domain.Company;
import com.xpress.onboarding.api.exceptions.CustomErrorType;
import com.xpress.onboarding.api.services.ICompanyService;

@RestController
@RequestMapping("/onboarding")
public class CompanyController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	ICompanyService companyService;

	@GetMapping("/hello")
	public String hello() {
		return "Hi";
	}

	@GetMapping(value = "/companies")
	public ResponseEntity<List<Company>> getAllcompanies() {
		List<Company> companies = companyService.getAllCompanies();
		if (companies.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
	}

	@GetMapping(value = "/companies/{id}")
	public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable("id") final Integer companyId) {
		Optional<Company> company=companyService.getCompanyById(companyId);
		return ResponseEntity.ok().body(company);
	}

	@PostMapping(value = "/companies")
	public ResponseEntity<String> addCompany(@RequestBody final Company company) {
		Company savedCompany=companyService.addCompany(company);
		return ResponseEntity.ok().body("New Company has been saved with ID: " + savedCompany.getCompanyId());
	}

	@PutMapping(value = "/companies/{id}")
	public ResponseEntity<?> updateCompany(@RequestBody final Company company, @PathVariable("id") Integer companyId) {
		companyService.updateCompany(companyId, company);
		/*if(updatedCompany ==null) {
			logger.error("Unable to update. User with id {} not found.", companyId);
			CustomErrorType error=new CustomErrorType("Unable to upate. User with id " + id + " not found.") 
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}*/
		return ResponseEntity.ok().body("Company has been updated successfully for the Company ID "+companyId);
	}

	@DeleteMapping(value = "/companies/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer companyId) {
		logger.info("Deleting the company for the ID" + companyId);
		Optional<Company> company = companyService.getCompanyById(companyId);
		if (!company.isPresent()) {
			logger.error("Unable to delete the company with id {}", companyId);
			CustomErrorType error = new CustomErrorType(
					"Unable to delete the company with id " + companyId + " not found.");
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		}
		companyService.deleteCompany(companyId);
		//return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("Company has been deleted successfully for the ID: " +companyId);
	}

	@DeleteMapping(value = "/companies")
	public ResponseEntity<String> deleteAllCompanies(){
		logger.info("Deleting All Companies");
		companyService.deleteAllCompanies();
		//return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("All companies have been deleted successfully");
	}
}
