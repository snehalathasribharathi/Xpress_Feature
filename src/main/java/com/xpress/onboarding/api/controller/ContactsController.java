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

import com.xpress.onboarding.api.domain.Contacts;
import com.xpress.onboarding.api.exceptions.CustomErrorType;
import com.xpress.onboarding.api.services.IContactService;

@RestController
@RequestMapping("/onboarding")
public class ContactsController {

	private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);

	@Autowired
	IContactService contactService;

	/*@GetMapping("/hello")
	public String hello() {
		return "Hi";
	}*/

	@GetMapping(value = "/contacts")
	public ResponseEntity<List<Contacts>> getAllContacts() {
		List<Contacts> contacts = contactService.getAllContacts();
		if (contacts.isEmpty()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Contacts>>(contacts, HttpStatus.OK);
	}

	@GetMapping(value = "/contacts/{id}")
	public ResponseEntity<Optional<Contacts>> getContactsById(@PathVariable("id") final Integer contactId) {
		Optional<Contacts> contacts = contactService.getContactsById(contactId);
		return ResponseEntity.ok().body(contacts);
	}

	@PostMapping(value = "/contacts")
	public ResponseEntity<String> addContacts(@RequestBody final Contacts contacts) {
		Contacts savedContacts = contactService.addContacts(contacts);
		return ResponseEntity.ok().body("New Contact has been saved with ID: " + savedContacts.getContactId());
	}

	@PutMapping(value = "/contacts/{id}")
	public ResponseEntity<String> updateContacts(@RequestBody final Contacts contacts,
			@PathVariable("id") Integer contactId) {
		contactService.updateContacts(contactId, contacts);
		return ResponseEntity.ok().body("Contacts has been updated successfully with the account ID " + contactId);
	}

	@DeleteMapping(value = "/contacts/{id}")
	public ResponseEntity<?> deleteContacts(@PathVariable("id") Integer contactId) {
		logger.info("Deleting the contacts for the ID" + contactId);
		Optional<Contacts> contacts = contactService.getContactsById(contactId);
		if (!contacts.isPresent()) {
			logger.error("Unable to delete the contacts with id {}", contactId);
			CustomErrorType error = new CustomErrorType(
					"Unable to delete the contacts with id " + contactId + " not found.");
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		}
		contactService.deleteContacts(contactId);
		// return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("Contact has been deleted successfully for the ID: " + contactId);
	}

	@DeleteMapping(value = "/contacts")
	public ResponseEntity<String> deleteAllContacts() {
		logger.info("Deleting All Contacts");
		contactService.deleteAllContacts();
		// return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().body("All Contacts have been deleted successfully");
	}
}
