package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ocr.paybuddy.dto.ConnectionDto;
import com.ocr.paybuddy.dto.CurrentUserMailDto;
import com.ocr.paybuddy.service.UserService;

@Controller
public class ConnectionController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/pageAddConnection")
	public String pageAddConnection(Model model,
			@ModelAttribute("currentUserMailDto") CurrentUserMailDto currentUserMailDto) {
		String mail = currentUserMailDto.getMail();
		CurrentUserMailDto currentUserMail = new CurrentUserMailDto(mail);
		ConnectionDto connectionDto = new ConnectionDto();
		model.addAttribute("currentUserMail", currentUserMail);
		model.addAttribute("connectionDto", connectionDto);
		return "addconnection";
	}

	@PostMapping(value = "/addconnection")
	public String addConnection(@ModelAttribute("connectionDto") ConnectionDto connectionDto) throws Exception {
		if (userService.addConnection(userService.getCurrentUserID(connectionDto.getOwner()),
				connectionDto.getMail())) {
			return "success";
		} else {
			return "addconnection";
		}
	}
}
