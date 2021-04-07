package com.ocr.paybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.paybuddy.dao.ConnectionDaoImpl;
import com.ocr.paybuddy.dao.TransactionDaoImpl;
import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.dto.ListUserConnectionsDto;
import com.ocr.paybuddy.model.User;

@Service
public class UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Autowired
	TransactionDaoImpl transactionDaoImpl;

	@Autowired
	ConnectionDaoImpl connectionDaoImpl;

	public ListUserConnectionsDto getConnections(int id) {
		ListUserConnectionsDto listUserConnections = new ListUserConnectionsDto(userDaoImpl.getConnections(id));
		return listUserConnections;
	}

	public void addConnection(int userID, String Email) {
		// Récupérer la connection à ajouter
		User user = userDaoImpl.findUserByMail(Email);
		// On ne prend que l'id (a voir pr mettre dans DTO)
		int buddy_id = user.getId();
		// Ajouter la connection pour l'user en cours
		connectionDaoImpl.addConnection(userID, buddy_id);
	}
}
