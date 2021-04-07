package com.ocr.paybuddy.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Transaction {
	private int id;
	@NotBlank
	private String description;
	@NotBlank
	private double amout;
	@NotBlank
	private double fare;
	@NotNull
	private String sender;
	@NotNull
	private String receiver;

	public Transaction(int id, @NotBlank String description, @NotBlank double amout, @NotBlank double fare,
			@NotNull String sender, @NotNull String receiver) {
		super();
		this.id = id;
		this.description = description;
		this.amout = amout;
		this.fare = fare;
		this.sender = sender;
		this.receiver = receiver;
	}

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

	public double getAmout() {
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

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
