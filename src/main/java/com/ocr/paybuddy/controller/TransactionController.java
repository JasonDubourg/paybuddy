package com.ocr.paybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.paybuddy.dto.ListUserTransactionsDto;
import com.ocr.paybuddy.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping(value = "/transactions")
	@ResponseStatus(HttpStatus.OK)
	public ListUserTransactionsDto getUserTransactions(int id) {
		return transactionService.getUserTransactions(id);
	}

	@PostMapping(value = "/sendmoney")
	public void sendMoneyToBuddy(int idSender, int idReceiver, String description, double amount) {
		try {
			transactionService.sendMoney(idSender, idReceiver, description, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
