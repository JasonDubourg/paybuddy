package com.ocr.paybuddy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ocr.paybuddy.model.User;

@Component
public class UserDto {
	private int id;
	private String firstName;
	private String lastName;
	private List<User> connections;

	public UserDto() {
		super();
	}

	public UserDto(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserDto(int id, String firstName, String lastName, List<User> connections) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.connections = connections;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<User> getConnections() {
		return connections;
	}

	public void setConnections(List<User> connections) {
		this.connections = connections;
	}

}
