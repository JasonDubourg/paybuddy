package com.ocr.paybuddy.dto;

public class ConnectionDto {
	private String owner;
	private String mail;

	public ConnectionDto() {
		super();
	}

	public ConnectionDto(String owner, String mail) {
		super();
		this.owner = owner;
		this.mail = mail;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
