package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.paybuddy.dto.ListUserConnectionsDto;
import com.ocr.paybuddy.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/connections")
	@ResponseStatus(HttpStatus.OK)
	public ListUserConnectionsDto getUserConnections(@RequestParam("id") int id) {
		return userService.getConnections(id);
	}

	@PostMapping(value = "/addconnection")
	@ResponseStatus(HttpStatus.OK)
	public void addConnection(@RequestParam("userId") int userId, @RequestParam("email") String email) {
		userService.addConnection(userId, email);
	}
}
