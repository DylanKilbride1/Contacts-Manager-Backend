package com.map.assignment.services;

import com.map.assignment.models.Users;
import com.map.assignment.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

	@Autowired
	private UsersRepository usersRepository;

	public Map<String, String> validateUser(Map<String, String> loginDetails) {
		Map<String, String> resultMap = new HashMap<>();
		if (usersRepository.existsByEmailAddress(loginDetails.get("email"))
						&& usersRepository.existsByPassword(loginDetails.get("password"))) {
			Users user = usersRepository.findUsersByEmailAddress(loginDetails.get("email"));
			resultMap.put("result", "1");
			resultMap.put("userId", Long.toString(user.getId()));
			resultMap.put("name", user.getFirstName() + " " + user.getLastName());
			System.out.println(user.getId());
			return resultMap;
		} else {
			resultMap.put("result", "0");
			return resultMap;
		}
	}
}