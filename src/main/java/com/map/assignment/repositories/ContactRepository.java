package com.map.assignment.repositories;

import com.map.assignment.models.Contact;
import com.map.assignment.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	boolean existsByEmailAddress(String emailAddress);
	List<Contact> findAllByUser(long userId);
}
