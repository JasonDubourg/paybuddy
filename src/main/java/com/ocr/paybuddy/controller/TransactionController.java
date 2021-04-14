package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ocr.paybuddy.dto.CurrentUserDto;
import com.ocr.paybuddy.dto.SendMoneyDto;
import com.ocr.paybuddy.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping(value = "/sendmoney")
	public String sendMoneyToBuddy(@ModelAttribute SendMoneyDto sendMoneyDto) throws Exception {
		CurrentUserDto currentUserDto = new CurrentUserDto(4);
		if (transactionService.sendMoney(currentUserDto.getId(), sendMoneyDto.getIdReceiver(),
				sendMoneyDto.getDescription(), sendMoneyDto.getAmount())) {
			return "redirect:/";
		} else {
			return "redirect:/";
		}
	}
}
