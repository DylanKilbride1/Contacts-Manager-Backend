package com.map.assignment.services;

import com.map.assignment.models.Users;
import com.map.assignment.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegistrationService {

	@Autowired
	private UsersRepository usersRepository;

	public String checkIfUserAlreadyExists(Map<String, String> user) {
		String result;

		if (usersRepository.existsByEmailAddress(user.get("email_address"))) {
			result = "false";
			return result;
		} else {
			usersRepository.save(new Users(user.get("first_name"),
							user.get("last_name"),
							user.get("email_address"),
							user.get("password"),
							user.get("mobile_number")));
			result = "true";
			return result;
		}
	}
}