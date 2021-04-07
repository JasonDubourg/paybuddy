package com.ocr.paybuddy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ocr.paybuddy.model.User;

@Component
public class ListUserConnectionsDto {

	private List<User> listUserConnections;

	public ListUserConnectionsDto(List<User> listUserConnections) {
		this.listUserConnections = listUserConnections;
	}

	public List<User> getListUserConnections() {
		return listUserConnections;
	}

	public void setListUserConnections(List<User> listUserConnections) {
		this.listUserConnections = listUserConnections;
	}

}
