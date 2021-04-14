package com.ocr.paybuddy.dto;

public class SendMoneyDto {
	private int idReceiver;
	private double amount;
	private String description;

	public SendMoneyDto() {
		super();
	}

	public SendMoneyDto(int idReceiver, double amount, String description) {
		super();
		this.idReceiver = idReceiver;
		this.amount = amount;
		this.description = description;
	}

	public int getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
