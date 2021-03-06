package com.map.assignment.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Users", schema = "contacts_manager_cloud_db")

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String mobileNumber;
	@OneToMany(cascade = CascadeType.ALL,
					fetch = FetchType.LAZY,
					mappedBy = "user")
	private Set<Contact> contacts = new HashSet<>();

	public Users(String firstName, String lastName, String emailAddress, String password, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public Users() {
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
}