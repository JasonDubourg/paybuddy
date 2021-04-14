package com.ocr.paybuddy.dto;

public class ConnectionDto {
	private String mail;

	public ConnectionDto() {
		super();
	}

	public ConnectionDto(String mail) {
		super();
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
