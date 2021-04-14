package com.ocr.paybuddy.dto;

import org.springframework.stereotype.Component;

@Component
public class TransactionDto {
	private String receiver;
	private String description;
	private double amout;

	public TransactionDto() {
		super();
	}

	public TransactionDto(String receiver, String description, double amout) {
		super();
		this.receiver = receiver;
		this.description = description;
		this.amout = amout;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public void setAmout(double amout) {
		this.amout = amout;
	}

}
