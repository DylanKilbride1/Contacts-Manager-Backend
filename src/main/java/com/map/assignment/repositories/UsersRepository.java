package com.map.assignment.repositories;

import com.map.assignment.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	boolean existsByEmailAddress(String emailAddress);
	boolean existsByPassword(String password);
	Users findUsersByEmailAddress(String emailAddress);
	Users findUsersById(long id);
}