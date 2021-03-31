package com.ocr.paybuddy.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String socialMediaString;
	@NotBlank
	private double balance;
	private String iban;
	private List<Transaction> transactions;
	private List<User> connections;

	public User() {
		super();
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int id, String firstName, String lastName, String mail, String socialMediaString,
			@NotBlank double balance, String iban) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.socialMediaString = socialMediaString;
		this.balance = balance;
		this.iban = iban;
		this.transactions = new ArrayList<>();
		this.connections = new ArrayList<>();
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSocialMediaString() {
		return socialMediaString;
	}

	public void setSocialMediaString(String socialMediaString) {
		this.socialMediaString = socialMediaString;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<User> getConnections() {
		return connections;
	}

	public void setConnections(List<User> connections) {
		this.connections = connections;
	}
}
