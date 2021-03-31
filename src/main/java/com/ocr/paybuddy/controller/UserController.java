package com.ocr.paybuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.paybuddy.model.User;
import com.ocr.paybuddy.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/connections")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUserConnectionsFromList(@RequestParam("id") int id) {
		return userService.getConnectionsFromUserList(id);
	}
}
