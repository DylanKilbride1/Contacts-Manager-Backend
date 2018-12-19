package com.map.assignment.controllers;

import com.map.assignment.models.Contact;
import com.map.assignment.models.Users;
import com.map.assignment.repositories.UsersRepository;
import com.map.assignment.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

	@Autowired
	ContactService contactService;
	@Autowired
	UsersRepository usersRepository;

	@RequestMapping(value = "/addsinglecontact",
					method = RequestMethod.POST,
					consumes = "application/json",
					produces = "application/json")
	public String addSingleContact(@RequestBody final Map<String, String> singleContact) {
		String userId = singleContact.get("userId");
		long userIdLong = Long.parseLong(userId);
		Users user = usersRepository.findUsersById(userIdLong);
		Contact contact = new Contact(singleContact.get("firstName"),
						singleContact.get("lastName"),
						singleContact.get("email"),
						singleContact.get("phone"),
						user);
		if(contactService.persistSingleContact(contact)) {
			return "Added To Cloud";
		} else {
			return "Nothing Happened";
		}
	}

	//Method not implemented in app
	//Functionality not implemented here
	@RequestMapping(value = "/addmultiplecontacts",
					method = RequestMethod.POST,
					consumes = "application/json",
					produces = "application/json")
	public String addMultipleContacts() {
		return null;
	}

	//Method not implemented in app
	//Functionality not implemented correctly here
	@RequestMapping(value = "/returnallcontacts",
					method = RequestMethod.GET,
					consumes = "application/json",
					produces = "application/json")
	@ResponseBody
	public List<Contact>returnAllContacts(@RequestBody final Map<String, String> user) {
		String userId = user.get("userId");
		long userIdLong = Long.parseLong(userId);
		return contactService.getAllContacts(userIdLong);
	}
}
