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

import com.xpress.onboarding.api.domain.LegalAgreements;
import com.xpress.onboarding.api.exceptions.CustomErrorType;
import com.xpress.onboarding.api.services.LegalAgreementService;

@RestController
@RequestMapping("/onboarding")
public class LegalAgreementsController {

	private static final Logger logger = LoggerFactory.getLogger(LegalAgreementService.class);

	@Autowired
	LegalAgreementService legalAgreementService;

	/*@GetMapping("/hello")
	public String hello() {
		return "Hi";
	}
*/
	@GetMapping(value = "/legalAgreements")
	public ResponseEntity<List<LegalAgreements>> getAllLegalAgreements() {
		List<LegalAgreements> legalAgreements = legalAgreementService.getAllLegalAgreements();
		if (legalAgreements.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LegalAgreements>>(legalAgreements, HttpStatus.OK);
	}

	@GetMapping(value = "/legalAgreements/{id}")
	public ResponseEntity<Optional<LegalAgreements>> getLegalAgreementsById(@PathVariable("id") final Integer agreementId) {
		Optional<LegalAgreements> legalAgreements = legalAgreementService.getLegalAgreementsById(agreementId);
		return ResponseEntity.ok().body(legalAgreements);
	}

	@PostMapping(value = "/legalAgreements")
	public ResponseEntity<String> addLegalAgreements(@RequestBody final LegalAgreements legalAgreements) {
		LegalAgreements savedAgreements = legalAgreementService.addLegalAgreements(legalAgreements);
		return ResponseEntity.ok().body("New Agreement has been saved with ID: " + savedAgreements.getAgreementId());
	}

	@PutMapping(value = "/legalAgreements/{id}")
	public ResponseEntity<String> updateLegalAgreements(@RequestBody final LegalAgreements legalAgreements,
			@PathVariable("id") Integer agreementId) {
		legalAgreementService.updateLegalAgreements(agreementId, legalAgreements);
		return ResponseEntity.ok().body("Legal Agreement has been updated successfully with the account ID " + agreementId);
	}

	@DeleteMapping(value = "/legalAgreements/{id}")
	public ResponseEntity<?> deleteLegalAgreements(@PathVariable("id") Integer agreementId) {
		logger.info("Deleting the agreement for the ID" + agreementId);
		Optional<LegalAgreements> legalAgreements = legalAgreementService.getLegalAgreementsById(agreementId);
		if (!legalAgreements.isPresent()) {
			logger.error("Unable to delete the agreement with id {}", agreementId);
			CustomErrorType error = new CustomErrorType(
					"Unable to delete the agreement with id " + agreementId + " not found.");
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		}
		legalAgreementService.deleteLegalAgreements(agreementId);
		// return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("Legal Agreement has been deleted successfully for the ID: " + agreementId);
	}

	@DeleteMapping(value = "/legalAgreements")
	public ResponseEntity<String> deleteAllLegalAgreements(){
		logger.info("Deleting All Agreements");
		legalAgreementService.deleteAllLegalAgreements();
		// return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("All Agreements have been deleted successfully");
	}
}
