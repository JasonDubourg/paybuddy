package com.ocr.paybuddy.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Transaction {
	private int id;
	@NotBlank
	private String description;
	@NotBlank
	private int amout;
	@NotBlank
	private double fare;
	@NotNull
	private User sender;
	@NotNull
	private User receiver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
}
