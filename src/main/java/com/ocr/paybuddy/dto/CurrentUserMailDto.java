package com.ocr.paybuddy.dto;

public class CurrentUserMailDto {

	private String mail;

	public CurrentUserMailDto() {
		super();
	}

	public CurrentUserMailDto(String mail) {
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
