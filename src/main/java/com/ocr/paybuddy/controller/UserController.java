package com.ocr.paybuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ocr.paybuddy.dto.ConnectionDto;
import com.ocr.paybuddy.dto.CurrentUserDto;
import com.ocr.paybuddy.dto.SendMoneyDto;
import com.ocr.paybuddy.dto.TransactionDto;
import com.ocr.paybuddy.dto.UserDto;
import com.ocr.paybuddy.service.LoginService;
import com.ocr.paybuddy.service.TransactionService;
import com.ocr.paybuddy.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	LoginService loginService;

	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/")
	@ResponseStatus(HttpStatus.OK)
	public String getUserTransfer(Model model) {
		List<UserDto> connections = userService.getConnections(4);
		List<TransactionDto> transactionsList = transactionService.getUserTransactions(4);
		SendMoneyDto sendMoneyDto = new SendMoneyDto();
		model.addAttribute("connections", connections);
		model.addAttribute("transactions", transactionsList);
		model.addAttribute("sendMoneyDto", sendMoneyDto);
		return "transfer";
	}

	@PostMapping(value = "/addconnection")
	@ResponseStatus(HttpStatus.OK)
	public String addConnection(@ModelAttribute ConnectionDto connectionDto) throws Exception {
		// METTRE L'USER COURRANT
		CurrentUserDto currentUserDto = new CurrentUserDto(4);
		if (userService.addConnection(currentUserDto.getId(), connectionDto.getMail())) {
			System.out.println("OK");
			return "redirect:http://www.google.fr";
		} else {
			return "redirect:/addconnection";
		}
	}

	@GetMapping(value = "/addconnection")
	@ResponseStatus(HttpStatus.OK)
	public String pageConnection(@ModelAttribute ConnectionDto connectionDtol) {
		return "addconnection";
	}

}
