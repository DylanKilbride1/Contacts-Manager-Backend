package com.map.assignment.controllers;

import com.map.assignment.repositories.UsersRepository;
import com.map.assignment.services.LoginService;
import com.map.assignment.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	RegistrationService registrationService;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	public String registerNewUser(@RequestParam final Map<String, String> details) {
		return registrationService.checkIfUserAlreadyExists(details);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Map<String, String> existingUserLogin(@RequestBody final Map<String, String> loginDetails) {
		return loginService.validateUser(loginDetails);
	}
}