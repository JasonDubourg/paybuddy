package com.ocr.paybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.model.User;

@Service
public class LoginService {

	@Autowired
	UserDaoImpl userDaoImpl;

	public boolean login(String email, String password) throws Exception {
		User user = userDaoImpl.findUserByMail(email);
		Boolean userLogin = false;
		if (!user.getMail().isEmpty() && user.getMail().equals(email) && user.getPassword().equals(password)) {
			userLogin = true;
		} else {
			throw new Exception("Acces refused");
		}
		return userLogin;
	}

}
