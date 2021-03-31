package com.ocr.paybuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.model.User;

@Service
public class UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	public List<User> getConnectionsFromUserList(int id) {
		List<User> listUser = userDaoImpl.getConnectionsFromUserList(id);
		return listUser;
	}

}
