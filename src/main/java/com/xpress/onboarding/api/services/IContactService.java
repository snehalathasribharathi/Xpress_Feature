package com.xpress.onboarding.api.services;

import java.util.List;
import java.util.Optional;

import com.xpress.onboarding.api.domain.Contacts;

public interface IContactService {
	List<Contacts> getAllContacts();

	Optional<Contacts> getContactsById(Integer id);

	Contacts addContacts(Contacts contacts);

	Contacts updateContacts(int id, Contacts contacts);

	void deleteContacts(Integer id);

	void deleteAllContacts();
}
