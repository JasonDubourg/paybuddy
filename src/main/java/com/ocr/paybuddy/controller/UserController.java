package com.ocr.paybuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ocr.paybuddy.dto.ConnectionDto;
import com.ocr.paybuddy.dto.CurrentUserDto;
import com.ocr.paybuddy.dto.CurrentUserMailDto;
import com.ocr.paybuddy.dto.SendMoneyDto;
import com.ocr.paybuddy.dto.TransactionDto;
import com.ocr.paybuddy.dto.UserDto;
import com.ocr.paybuddy.dto.UserLoginDto;
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
	public String getUserTransfer(Model model, @ModelAttribute("userLogin") UserLoginDto userLogin) {
		String currentUser = userLogin.getMail();
		CurrentUserDto currentUserDto = new CurrentUserDto(userService.getCurrentUserID(currentUser));
		List<UserDto> connections = userService.getConnections(currentUserDto.getId());
		List<TransactionDto> transactionsList = transactionService.getUserTransactions(currentUserDto.getId());
		SendMoneyDto sendMoneyDto = new SendMoneyDto();
		ConnectionDto connectionDto = new ConnectionDto();
		CurrentUserMailDto currentUserMailDto = new CurrentUserMailDto(userLogin.getMail());
		model.addAttribute("connections", connections);
		model.addAttribute("transactions", transactionsList);
		model.addAttribute("sendMoneyDto", sendMoneyDto);
		model.addAttribute("currentUser", currentUserDto);
		model.addAttribute("currentUser", currentUserDto);
		model.addAttribute("connectionDto", connectionDto);
		model.addAttribute("currentUserMailDto", currentUserMailDto);
		return "transfer";
	}

	@PostMapping(value = "/connection")
	public String pageConnection(@ModelAttribute("currentUserMailDto") CurrentUserMailDto currentUserMailDto,
			final Model model, final BindingResult mapping1BindingResult, final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("currentUserMailDto", currentUserMailDto);
		return "redirect:/pageAddConnection";
	}

}
