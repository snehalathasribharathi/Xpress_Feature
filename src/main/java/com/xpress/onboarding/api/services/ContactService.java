package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpress.onboarding.api.dao.ContactsRepository;
import com.xpress.onboarding.api.domain.Accounts;
import com.xpress.onboarding.api.domain.Contacts;

@Service
public class ContactService {

	private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

	@Autowired
	ContactsRepository contactsDao;

	public List<Contacts> getAllContacts() {
		logger.info("inside Contact Service.getAllContacts");
		return (List<Contacts>) contactsDao.findAll();
	}

	public Optional<Contacts> getContactsById(Integer id) {
		logger.info("Getting Contacts details for ID " + id);
		return contactsDao.findById(id);
	}

	public Contacts addContacts(Contacts contacts) {
		logger.info("Adding contacts " + contacts);
		return contactsDao.save(contacts);
	}

	public Contacts updateContacts(int id, Contacts contacts) {
		logger.info("Updating contacts for ID " + contacts);
		//contactsDao.save(contacts);
		Contacts updatedcontacts=null;
	        if(id== contacts.getContactId()) {
	        	updatedcontacts=contactsDao.save(contacts);
	        }
	        return updatedcontacts;
	}

	public void deleteContacts(Integer id) {
		logger.info("Deleting contacts for ID " + id);
		contactsDao.deleteById(id);
	}

	public void deleteAllContacts() {
		logger.info("Deleting all contacts ");
		contactsDao.deleteAll();
	}
}
