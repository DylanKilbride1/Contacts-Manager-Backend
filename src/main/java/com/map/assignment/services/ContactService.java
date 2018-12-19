package com.map.assignment.services;

import com.map.assignment.models.Contact;
import com.map.assignment.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactsRepository;

	public boolean persistSingleContact(Contact contact){
		if(!contactsRepository.existsByEmailAddress(contact.getEmailAddress())) {
			contactsRepository.save(contact);
			return true;
		} else {
			return false;
		}
	}

	public List<Contact> getAllContacts(long userId){
		return contactsRepository.findAllByUser(userId);
	}
}
