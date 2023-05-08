package com.crm.services;

import java.util.List;

import com.crm.entities.Contact;
import com.crm.entities.Lead;

public interface ContactService {

	void saveContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactById(long id);

	 

	 

}
