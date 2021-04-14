package com.ocr.paybuddy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.paybuddy.dao.ConnectionDaoImpl;
import com.ocr.paybuddy.dao.TransactionDaoImpl;
import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.dto.ConnectionDto;
import com.ocr.paybuddy.dto.UserDto;
import com.ocr.paybuddy.model.User;

@Service
public class UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Autowired
	TransactionDaoImpl transactionDaoImpl;

	@Autowired
	ConnectionDaoImpl connectionDaoImpl;

	public List<UserDto> getConnections(int id) {
		List<UserDto> listConnections = new ArrayList<>();
		List<User> listUserConnections = userDaoImpl.getConnections(id);
		for (User user : listUserConnections) {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			listConnections.add(userDto);
		}
		return listConnections;
	}

	public boolean addConnection(int userID, String email) throws Exception {
		User user = userDaoImpl.findUserByMail(email);
		boolean isInList = this.findConnectionInList(userID, user.getMail());
		boolean addSuccess = false;
		if (!isInList && !user.getMail().isEmpty() && user.getMail().equals(email)) {
			int buddy_id = user.getId();
			connectionDaoImpl.addConnection(userID, buddy_id);
			addSuccess = true;
		} else {
			throw new Exception("This buddy is not register");
		}
		return addSuccess;
	}

	public boolean findConnectionInList(int userID, String email) {
		boolean isInList = false;
		List<ConnectionDto> connectionDtos = new ArrayList<>();
		List<User> connectionsList = userDaoImpl.getConnections(userID);
		for (User user : connectionsList) {
			ConnectionDto connectionDto = new ConnectionDto();
			connectionDto.setMail(user.getMail());
			connectionDtos.add(connectionDto);
		}
		for (ConnectionDto connection : connectionDtos) {
			if (connection.getMail().equalsIgnoreCase(email)) {
				isInList = true;
			}
		}
		return isInList;
	}

}
