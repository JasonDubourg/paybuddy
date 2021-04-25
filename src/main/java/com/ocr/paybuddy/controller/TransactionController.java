package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ocr.paybuddy.dto.SendMoneyDto;
import com.ocr.paybuddy.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping(value = "/sendmoney")
	public String sendMoneyToBuddy(@ModelAttribute("sendMoneyDto") SendMoneyDto sendMoneyDto) throws Exception {
		if (transactionService.sendMoney(sendMoneyDto.getIdSender(), sendMoneyDto.getIdReceiver(),
				sendMoneyDto.getDescription(), sendMoneyDto.getAmount())) {
			return "success";
		} else {
			return "/";
		}
	}
}
